package services.module1.interfaces;


import java.util.List;

import javax.ejb.Remote;

import entities.Command;

@Remote
public interface CommandServiceRemote {
	public void addCommand(Command command);
	
	public void updateCommand(Command command);
	
	public void deleteCommand(Command command);
	
	public Command findCommandById(int id);
	
	public List<Command> getAllCommands();
	
}
