package by.htp.jwd.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.jwd.command.impl.AddNewCar;
import by.htp.jwd.command.impl.AddNewCarView;
import by.htp.jwd.command.impl.IndexView;
import by.htp.jwd.command.impl.Logination;
import by.htp.jwd.command.impl.RegistrationView;
import by.htp.jwd.command.impl.SaveUser;

public class CommandProvider {
	
	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());	
		commands.put(CommandName.INDEXVIEW, new IndexView());
		commands.put(CommandName.REGISTRATION, new RegistrationView());
		commands.put(CommandName.SAVEUSER, new SaveUser());
		commands.put(CommandName.ADDNEWCAR, new AddNewCar());
		commands.put(CommandName.ADDNEWCARVIEW, new AddNewCarView());
	}

	public Command takeCommand(String name) {
		CommandName commandName;
		commandName = CommandName.valueOf(name.toUpperCase());
		return commands.get(commandName);
	}
}