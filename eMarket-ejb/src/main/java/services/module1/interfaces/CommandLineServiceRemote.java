package services.module1.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.CommandLine;

@Remote
public interface CommandLineServiceRemote {
public void addCommandLine(CommandLine commandLine);
	
	public void updateCommandLine(CommandLine commandLine);
	
	public void deleteCommandLine(CommandLine commandLine);
	
	public CommandLine getCommandLineById(int id);
	
	public List<CommandLine>getAllCommandLine();

}