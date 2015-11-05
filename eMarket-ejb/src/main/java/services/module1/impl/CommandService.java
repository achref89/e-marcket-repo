package services.module1.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.module1.interfaces.CommandServiceLocal;
import services.module1.interfaces.CommandServiceRemote;
import entities.Command;

/**
 * Session Bean implementation class CommandService
 */
@Stateless
public class CommandService implements CommandServiceRemote,
		CommandServiceLocal {

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
		Query query = entityManager.createQuery("select cmd from Command cmd");
		return query.getResultList();// TODO Auto-generated method stub

	}

}
