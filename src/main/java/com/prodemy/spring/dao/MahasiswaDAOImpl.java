package com.prodemy.spring.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prodemy.spring.model.Mahasiswa;

@Repository
public class MahasiswaDAOImpl implements MahasiswaDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MahasiswaDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	public void addMahasiswa(Mahasiswa p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Phone saved successfully, Phone Details=" + p);
	}
	
	@Override
	public void updateMahasiswa(Mahasiswa p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Phone updated successfully, Phone Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mahasiswa> listMahasiswa() {
		Session session = this.sessionFactory.getCurrentSession(
			);
		List<Mahasiswa> mahasiswasList = session.createQuery("from Mahasiswa").list();
		for (Mahasiswa p : mahasiswasList) {
		logger.info("Mahasiswa List::" + p);
		}
			return mahasiswasList;
			}
	@Override
	public Mahasiswa getMahasiswaById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Mahasiswa p = (Mahasiswa) session.load(Mahasiswa.class, new Integer(id));
		logger.info("Phone loaded successfully, Phone details=" + p);
		return p;
	}
	@Override
	public void removeMahasiswa(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Mahasiswa p = (Mahasiswa) session.load(Mahasiswa.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Phone deleted successfully, phone details=" + p);
	}
}
