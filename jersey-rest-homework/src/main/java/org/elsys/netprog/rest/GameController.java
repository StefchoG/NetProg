package org.elsys.netprog.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/game")
public class GameController {
	
	Integer myGameId = 0;
	HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	
	
	@POST
	@Path("/startGame")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response startGame() throws URISyntaxException{
		//TODO: Add your code here
		hmap.put(myGameId + 1, BullsAndCows.targetStr);
		return Response.created(new URI("/games")).entity(myGameId).build();
	}
	
	@PUT
	@Path("/guess/{id}/{guess}")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response guess(@PathParam("id") String gameId, @PathParam("guess") String guess) throws Exception{
		//TODO: Add your code here
		if(gameId != myGameId.toString()) {
		return Response.status(404).build();
		}else {
			BullsAndCows.main(guess);
			if(BullsAndCows.guessed) {
				return Response.status(200).entity(gameId).entity(BullsAndCows.cows).entity(BullsAndCows.cows).entity(BullsAndCows.guesses).build();
			}
			else {
				return Response.status(400).build();
			}
			
		}
	}
	
	@GET
	@Path("/games")
	@Produces(value={MediaType.APPLICATION_JSON})
	public Response getGames() {
		//TODO: Add your code here
		return Response.status(404).build();
	}
}