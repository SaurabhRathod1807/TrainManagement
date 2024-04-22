package com.example.SpringProjects.Controller;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringProjects.Entity.Train;

@RestController
public class TrainController {

	@Autowired
	SessionFactory sf;

	@PostMapping("addTrain")
	public void addTrain(@RequestBody Train train) {
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(train);
		t.commit();
	}

	@GetMapping("getTrainbyid/{trainid}")
	public List<Train> getTrainbyid(@PathVariable Long trainid) {
		try (Session s = sf.openSession()) {
			Query query = s.createQuery("from Train where trainid = :trainid");
			query.setParameter("trainid", trainid);
			List<Train> list = query.list();
			return list;
		} catch (Exception e) {

			e.printStackTrace();
			return Collections.emptyList();
		}

	}

	@GetMapping("getTrainbysource/{source}")
	public List<Train> getTrainbysource(@PathVariable String source) {
		try (Session s = sf.openSession()) {
			Query query = s.createQuery("from Train where source = :source");
			query.setParameter("source", source);
			List<Train> list = query.list();
			return list;
		} catch (Exception e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@GetMapping("getTrainbyDestation/{Destation}")
	public List<Train> getTrainbyDestation(@PathVariable String Destation) {
		try (Session s = sf.openSession()) {
			Query query = s.createQuery("from Train where Destation = :Destation");
			query.setParameter("Destation", Destation);
			List<Train> list = query.list();
			return list;
		} catch (Exception e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@GetMapping("getTrainbytime/{time}")
	public List<Train> getTrainbytime(@PathVariable Double time) {
		try (Session s = sf.openSession()) {
			Query query = s.createQuery("from Train where time = :time");
			query.setParameter("time", time);
			List<Train> list = query.list();
			return list;
		} catch (Exception e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@GetMapping("getTrainbysd/{source}/{Destation}")
	public List<Train> getTrainbysd(@PathVariable String source, @PathVariable String Destation) {
		try (Session s = sf.openSession()) {
			Query query = s.createQuery("from Train where source = :source and Destation = :Destation");
			query.setParameter("source", source);
			query.setParameter("Destation", Destation);
			List<Train> list = query.list();
			return list;
		} catch (Exception e) {

			e.printStackTrace();
			return Collections.emptyList();
		}
	}

}
