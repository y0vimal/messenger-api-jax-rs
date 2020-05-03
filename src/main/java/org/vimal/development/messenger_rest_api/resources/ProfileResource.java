package org.vimal.development.messenger_rest_api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.vimal.development.messenger_rest_api.model.Profile;
import org.vimal.development.messenger_rest_api.service.ProfileService;

@Path ("/profiles")
public class ProfileResource {
	
	private final ProfileService profileService = new ProfileService();
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles(){
		return profileService.getProfiles();
	}
	
	@GET
	@Produces (MediaType.APPLICATION_JSON)
	@Path ("/{profileId}")
	public Profile getProfile(@PathParam ("profileId") String profileId) {
		return profileService.getProfile(profileId);
	}
	
	@POST
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	@Path ("/{profileId}")
	public Profile updateProfile(Profile profile, @PathParam ("profileId") String profileId) {
		profile.setProfileId(profileId);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path ("/{profileId}")
	public void deleteProfile(@PathParam ("profileId") String profileId) {
		profileService.deleteProfile(profileId);
	}

}
