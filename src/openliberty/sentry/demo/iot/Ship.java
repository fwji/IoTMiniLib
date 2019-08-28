package openliberty.sentry.demo.iot;

import java.io.IOException;
import java.net.InetAddress;

import openliberty.sentry.demo.iot.tcp.TCPCommand;

public class Ship extends IoTObject{

	private static Ship instance; 
	
	public Ship(){
		super();
	}
	
	public Ship(InetAddress serverAddress, int serverPort) {
		super(serverAddress, serverPort);
		// TODO Auto-generated constructor stub
	}
	
	public static Ship getInstance() {
		//boolean pingSuccessful = false;
		int retry = 2;
		while ((instance == null || !!!instance.isConnected()) && retry > 0) {
			try {
				instance = new Ship();
				
				String ip = System.getProperty("ship.ip");
				int port = Integer.valueOf(System.getProperty("ship.port"));
				
				instance.setHost(InetAddress.getByName(ip), port);
				instance.connect();
				retry--;
				//pingSuccessful = instance.ping();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				retry--;
			}
		}

		return instance.isConnected() ? instance : null;
	}
	
	public void startShip() throws Exception {
		sendCommand(TCPCommand.T_GAMESTART);
	}
	
	public void panShipLeft() throws Exception {
		sendCommand(TCPCommand.S_PANSHIP_LEFT);
	}
	
	public void panShipRight() throws Exception {
		sendCommand(TCPCommand.S_PANSHIP_RIGHT);
	}
	
	public void panShipUp() throws Exception {
		sendCommand(TCPCommand.S_PANSHIP_UP);
	}
	
	public void panShipDown() throws Exception {
		sendCommand(TCPCommand.S_PANSHIP_DOWN);
	}
	
	public void panShipLeftFast() throws Exception {
		sendCommand(TCPCommand.S_PANSHIP_LEFT_2);
	}
	
	public void panShipRightFast() throws Exception {
		sendCommand(TCPCommand.S_PANSHIP_RIGHT_2);
	}
	
	public void panShipUpFast() throws Exception {
		sendCommand(TCPCommand.S_PANSHIP_UP_2);
	}
	
	public void panShipDownFast() throws Exception {
		sendCommand(TCPCommand.S_PANSHIP_DOWN_2);
	}
	
	public void fireLaser(){
		sendCommand(TCPCommand.S_FIRELASER);		
	}
	
	public void stopShip() throws Exception {
		sendCommand(TCPCommand.T_GAMESTOP);
	}
	
	public void disconnect() throws IOException {
		disconnect();
	}
}
