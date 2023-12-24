package com.app.service;

import java.util.List;

import com.app.entities.Courier;
import com.app.entities.StatusEnum;

public interface ICourierService {
	List<Courier> getAllCouriers();
	Courier getAnCourierDetails(long courierId);
	//Courier insertCourierDetails(Courier transientCurier);
	Courier insertCourierDetails(Courier transientCourier, long custId);
	List<Courier> getCouriersById(long custId);
	Courier getCourierDetailsByCourierId(long courierId);
	List<Courier> getAllCouriersByEmpId(long empId);
	Courier updateCourierStatusToPickedUp(long courierId);
	Courier updateCourierStatusToInTransit(long courierId);
	List<Courier> getAllCouriersInTransitState(StatusEnum valueOf);
	Courier alotACourierToBranchAdminAndChangeStatusWhichAreInTransitState(long courierId);//by admin
	List<Courier> getAllOrdersToBePickedUp(long empId, StatusEnum valueOf);
//	CourierEntity alotCourierToOneOfDeliveryBoy(CourierEntity detachedCourier, long empId);	
	List<Courier> getAllOrdersToBeDelivered(long empId, StatusEnum valueOf);
	Courier updateCourierStatusToDelivered(long courierId);
	Courier updateCourierStatusToUnsuccessfulDelivery(long courierId);
	List<Courier> getAllOrdersToBeDeliver(long empId, StatusEnum valueOf);
	public Courier alotCourierToOneOfDeliveryBoy(long dbid, long courierId);
	
}
