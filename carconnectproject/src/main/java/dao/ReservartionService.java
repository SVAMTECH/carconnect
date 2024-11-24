package dao;

import java.util.ArrayList;

import entity.Reservation;

public interface ReservartionService {
	
      public Reservation getReservationById(int reservationId);
      public ArrayList<Reservation> getReservationsByCustomerId(int customerId);
      public String createReservation(Reservation reservationData);
      public String updateReservation(Reservation reservationData,int reservationId);
      public String cancelReservation(int reservationId);
}
