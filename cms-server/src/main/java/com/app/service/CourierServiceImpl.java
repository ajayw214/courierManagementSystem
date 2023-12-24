package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IBranchRepository;
import com.app.dao.ICourierRepository;
import com.app.dao.ICustomerRepository;
import com.app.dao.IEmployeeRepository;
import com.app.entities.Branch;
import com.app.entities.Courier;
import com.app.entities.Customer;
import com.app.entities.Employee;
import com.app.entities.RoleEnum;
import com.app.entities.StatusEnum;

@Service
@Transactional
public class CourierServiceImpl implements ICourierService {

	@Autowired
	private ICourierRepository courierRepo;

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private IBranchRepository branchRepo;

	@Autowired
	private IEmployeeRepository employeeRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Courier> getAllCouriers() {
		List<Courier> courierList = courierRepo.findAll();
		return courierList;
	}

	@Override
	public Courier getAnCourierDetails(long courierId) {
		Courier courier = courierRepo.findById(courierId).get();
//		System.out.println(courier);
//		CourierDTO courierDto = new CourierDTO();
//		courierDto = mapper.map(courier, CourierDTO.class);
//   	System.out.println(courierDto);
		return courier;
	}
	@Override
	public Courier insertCourierDetails(Courier transientCourier, long custId) {
		Customer customer = customerRepo.findById(custId).get();
		transientCourier.setCustomerCouriers(customer);
		transientCourier.setStatus(StatusEnum.READY_FOR_PICKUP);
		double weight = transientCourier.getWeight();
		double amt = weight * 250;
		transientCourier.setAmount(amt);
		String pincode = transientCourier.getSendersPincode();
		Branch branch = branchRepo.findByPincode(pincode);
		Long id = branch.getId();
		Employee employee = employeeRepo.findByBranchIdAndRole(id, RoleEnum.valueOf("BRANCH_ADMIN"));
		transientCourier.setAllotedToDeliveryBoy(employee);
		transientCourier = courierRepo.save(transientCourier);
		return transientCourier;
	}


	@Override
	public List<Courier> getCouriersById(long custId) {
		List<Courier> courier = courierRepo.findByCustomerCouriersId(custId);
//		List<CourierDTO> courierDTO = new ArrayList<CourierDTO>();
//		for(CourierEntity c1 : courierEntity)
//			courierDTO.add(mapper.map(courierEntity, CourierDTO.class));
		return courier;
	}

	@Override
	public Courier getCourierDetailsByCourierId(long courierId) {
		Courier courier = courierRepo.findById(courierId).get();
		return courier;
	}

	@Override
	public List<Courier> getAllCouriersByEmpId(long empId) {
		List<Courier> courierEntity = courierRepo.findByAllotedToDeliveryBoyId(empId);
//		List<CourierDTO> courierDto = new ArrayList<CourierDTO>();
//		for(CourierEntity c1 : courierEntity)
//			courierDto.add(mapper.map(courierEntity, CourierDTO.class));
		return courierEntity;
	}

	@Override
	public Courier updateCourierStatusToPickedUp(long courierId) {
		Courier detachedCourier = courierRepo.findById(courierId).get();
		Customer customer = customerRepo.findById(detachedCourier.getCustomerCouriers().getId()).get();
		detachedCourier.setCustomerCouriers(customer);
		Employee employee = employeeRepo.findById(detachedCourier.getAllotedToDeliveryBoy().getId()).get();
		detachedCourier.setAllotedToDeliveryBoy(employee);
		detachedCourier.setStatus(StatusEnum.valueOf("PICKEDUP"));
		return courierRepo.save(detachedCourier);
	}

	@Override
	public Courier updateCourierStatusToInTransit(long courierId) {
		Courier detachedCourier = courierRepo.findById(courierId).get();
		Customer customer = customerRepo.findById(detachedCourier.getCustomerCouriers().getId()).get();
		detachedCourier.setCustomerCouriers(customer);
		Employee employee = employeeRepo.findById(detachedCourier.getAllotedToDeliveryBoy().getId()).get();
		detachedCourier.setAllotedToDeliveryBoy(employee);
		detachedCourier.setStatus(StatusEnum.valueOf("IN_TRANSIT"));
		return courierRepo.save(detachedCourier);
	}

	@Override
	public List<Courier> getAllCouriersInTransitState(StatusEnum valueOf) {
		List<Courier> courierList = courierRepo.findByStatus(StatusEnum.valueOf("IN_TRANSIT"));
		return courierList;
	}

	@Override
	public Courier alotACourierToBranchAdminAndChangeStatusWhichAreInTransitState(long courierId) {
		Courier detachedCourier = courierRepo.findById(courierId).get();
		String pincode = detachedCourier.getReceiversPincode();
		Branch branch = branchRepo.findByPincode(pincode);
		Long id = branch.getId();
		Employee employee = employeeRepo.findByBranchIdAndRole(id, RoleEnum.valueOf("BRANCH_ADMIN"));
		detachedCourier.setAllotedToDeliveryBoy(employee);
		detachedCourier.setStatus(StatusEnum.valueOf("DISPATCHED"));
		detachedCourier = courierRepo.save(detachedCourier);
		return detachedCourier;
	}

	@Override
	public List<Courier> getAllOrdersToBePickedUp(long empId, StatusEnum valueOf) {
		List<Courier> courierList = courierRepo.findByAllotedToDeliveryBoyIdAndStatus(empId, StatusEnum.valueOf("READY_FOR_PICKUP"));
		return courierList;
	}

	@Override
	public List<Courier> getAllOrdersToBeDelivered(long empId, StatusEnum valueOf) {
		List<Courier> courierList = courierRepo.findByAllotedToDeliveryBoyIdAndStatus(empId, StatusEnum.valueOf("DISPATCHED"));
		return courierList;
	}

	@Override
	public Courier updateCourierStatusToDelivered(long courierId) {
		Courier detachedCourier = courierRepo.findById(courierId).get();
		Customer customer = customerRepo.findById(detachedCourier.getCustomerCouriers().getId()).get();
		detachedCourier.setCustomerCouriers(customer);
		Employee employee = employeeRepo.findById(detachedCourier.getAllotedToDeliveryBoy().getId()).get();
		detachedCourier.setAllotedToDeliveryBoy(employee);
		detachedCourier.setStatus(StatusEnum.valueOf("DELIVERED"));
		return courierRepo.save(detachedCourier);
	}

	@Override
	public Courier updateCourierStatusToUnsuccessfulDelivery(long courierId) {
		Courier detachedCourier = courierRepo.findById(courierId).get();
		Customer customer = customerRepo.findById(detachedCourier.getCustomerCouriers().getId()).get();
		detachedCourier.setCustomerCouriers(customer);
		Employee employee = employeeRepo.findById(detachedCourier.getAllotedToDeliveryBoy().getId()).get();
		detachedCourier.setAllotedToDeliveryBoy(employee);
		detachedCourier.setStatus(StatusEnum.valueOf("UNSUCCESSFUL_DELIVERY"));
		return courierRepo.save(detachedCourier);
	}

	@Override
	public List<Courier> getAllOrdersToBeDeliver(long empId, StatusEnum valueOf) {
		List<Courier> courierList = courierRepo.findByAllotedToDeliveryBoyIdAndStatus(empId,
				StatusEnum.valueOf("DISPATCHED"));
		return courierList;
	}

	@Override
	public Courier alotCourierToOneOfDeliveryBoy(long dbid, long courierId) {
		Employee deliveryBoy = employeeRepo.findById(dbid).get();
		Courier couriertoballotted = courierRepo.findById(courierId).get();
		couriertoballotted.setAllotedToDeliveryBoy(deliveryBoy);
		courierRepo.save(couriertoballotted);
		return couriertoballotted;
	}

	public ModelMapper getMapper() {
		return mapper;
	}

	public void setMapper(ModelMapper mapper) {
		this.mapper = mapper;
	}

}
