package services.module1.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.CommandLine;
import services.module1.interfaces.CommandLineServiceLocal;
import services.module1.interfaces.CommandLineServiceRemote;

/**
 * Session Bean implementation class CommandLineService
 */
@Stateless
public class CommandLineService implements CommandLineServiceRemote, CommandLineServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager entityManager;
    public CommandLineService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCommandLine(CommandLine commandLine) {
		// TODO Auto-generated method stub
		entityManager.persist( commandLine);
		
	}

	@Override
	public void updateCommandLine(CommandLine commandLine) {
		// TODO Auto-generated method stub
		entityManager.merge(commandLine);
	}

	@Override
	public void deleteCommandLine(CommandLine commandLine) {
		// TODO Auto-generated method stub
		entityManager.remove(commandLine);
	}

	@Override
	public CommandLine getCommandLineById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(CommandLine.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CommandLine> getAllCommandLine() {
		// TODO Auto-generated method stub
		Query query=entityManager.createQuery("select cmdLine from CommandLine cmdline");
		return query.getResultList();
	}

}
