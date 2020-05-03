package org.vimal.development.messenger_rest_api.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vimal.development.messenger_rest_api.model.Profile;

public class ProfileService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileService.class);
	private Session session = null;

	public List<Profile> getProfiles() {
		
		session = DatabaseService.getSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Profile");
		
		List profiles = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		LOGGER.info("profile list size : {}", profiles.size());
		
		return profiles;
		
	}

	public Profile getProfile(String profileId) {
		session = DatabaseService.getSession();
		session.beginTransaction();
		
		Profile profile = session.get(Profile.class, profileId);
		
		session.getTransaction().commit();
		session.close();
		
		return profile;
	}

	public Profile addProfile(Profile profile) {
		session = DatabaseService.getSession();
		session.beginTransaction();
		
		session.save(profile);
		
		session.getTransaction().commit();
		session.close();
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		session = DatabaseService.getSession();
		session.beginTransaction();
		
		session.update(profile);
		
		session.getTransaction().commit();
		session.close();
		return profile;
	}

	public void deleteProfile(String profileId) {
		session = DatabaseService.getSession();
		session.beginTransaction();
		
		Profile profile = session.get(Profile.class, profileId);
		if(profile == null) {
			LOGGER.info("profile to be delted, does not exist");
			return;
		}
		session.delete(profile);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	

}
