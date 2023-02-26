package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/*
	 * Holds the next player identifier
	 */
	private static long nextPlayerId = 1;

	/*
	 * Holds the next team identifier
	 */
	private static long nextTeamId = 1;
	
	//private var to track existence of GameService
	private static GameService service = null;

	// Default constructor
	private GameService() {
	}

	public static GameService getInstance() {

        // Does GameService exist
	    if (service == null) {
            //create a new instance in heap memory
	        service = new GameService();
	        System.out.println("New Game Service created.");
        } else {
            //it already exists
            System.out.println("Game Service already instantiated.");
        }

        // Return new or existing, but only the single instance
        return service;
    }

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

        // instance iterator
        Iterator<Game> gamesIterator = games.iterator();

        // iterate over list
        while (gamesIterator.hasNext()) {

            //var to next item in list
            Game gameInstance = gamesIterator.next();

            //game name already exist?
            if (gameInstance.getName().equalsIgnoreCase(name)) {
                //name already exists, return the game instance
                return gameInstance;
            }
		}
		//not found, make a new game instance and add to list
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		//a local game instance
		Game game = null;

		//instance iterator
        Iterator <Game> gamesIterator = games.iterator();

        //iterate over list of games
        while (gamesIterator.hasNext()) {

            //var to next item in list
            Game gameInstance = gamesIterator.next();

            //game id already exist?
            if (gameInstance.getId() == id) {
                //game id exists, return the game instance
                return gameInstance;
            }
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		//local game instance
		Game game = null;

		//istance iterator
        Iterator<Game> gamesIterator = games.iterator();

        //iterate over games list
        while (gamesIterator.hasNext()) {

            //var to next item in list
            Game gameInstance = gamesIterator.next();

            //game name already exist?
            if (gameInstance.getName().equalsIgnoreCase(name)) {
                //game name exists, return the game instance
                game = gameInstance;
            }
        }

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	public long getNextPlayerId() {
	    return nextPlayerId;
    }

    public long getNextTeamId() {
        return nextTeamId;
    }
	
}
