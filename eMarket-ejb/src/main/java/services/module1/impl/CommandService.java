package services.module1.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Command;
import services.module1.interfaces.CommandServiceLocal;
import services.module1.interfaces.CommandServiceRemote;

/**
 * Session Bean implementation class Commande
 */
@Stateless
public class CommandService implements CommandServiceRemote, CommandServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
	
    public CommandService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCommand(Command command) {
		// TODO Auto-generated method stub
		entityManager.persist(command);
		
	}

	@Override
	public void updateCommand(Command command) {
		// TODO Auto-generated method stub
		entityManager.merge(command);
	}

	@Override
	public void deleteCommand(Command command) {
		// TODO Auto-generated method stub
		entityManager.remove(command);
	}

	@Override
	public Command findCommandById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Command.class, id);
	}

	@Override
	public List<Command> getAllCommands() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
