import javax.swing.JOptionPane;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.GuitarHeroEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.NunchukButtonsEvent;
import wiiusej.wiiusejevents.physicalevents.NunchukEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.ClassicControllerRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.GuitarHeroRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukInsertedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.NunchukRemovedEvent;
import wiiusej.wiiusejevents.wiiuseapievents.StatusEvent;

public class WiiRemote implements WiimoteListener
{

	public static void main (String args[])
	{
		new WiiRemote();
	}
	
	private Level level;
	private Wiimote[] wiimotes;
	
	public WiiRemote()
	{
		level = new Level();
		 wiimotes = WiiUseApiManager.getWiimotes(3, true);
		int wiimoteNumber = 0;
		for(Wiimote wiimote: wiimotes)
		{
			switch (wiimoteNumber) {
			case 0:
				wiimote.setLeds(true, false, false, false);
				wiimote.activateIRTRacking();
				wiimote.setSensorBarAboveScreen();
				wiimote.setVirtualResolution(500, 500);
				wiimote.setIrSensitivity(2);
				
				break;
			case 1:
				wiimote.setLeds(false, true,  false, false);
				wiimote.activateIRTRacking();
				wiimote.setSensorBarAboveScreen();
				wiimote.setVirtualResolution(500, 500);
				wiimote.setIrSensitivity(2);
				
				break;
			case 2:
				wiimote.setLeds(false, false, true, false);
				wiimote.activateIRTRacking();
				wiimote.setSensorBarAboveScreen();
				wiimote.setVirtualResolution(500, 500);
				wiimote.setIrSensitivity(2);
				
				break;
			}
			wiimoteNumber++;
			wiimote.addWiiMoteEventListeners(this);
		}
		
		if (wiimotes.length == 0)
		{
			System.out.println("No Wii Remotes found");
		}
		
		System.out.println(wiimotes.length);
		
	}

	@Override
	public void onClassicControllerInsertedEvent(ClassicControllerInsertedEvent arg0)
	{
		
	}

	@Override
	public void onClassicControllerRemovedEvent(ClassicControllerRemovedEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnectionEvent(DisconnectionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onExpansionEvent(ExpansionEvent arg0)
	{

		
	}

	@Override
	public void onGuitarHeroInsertedEvent(GuitarHeroInsertedEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGuitarHeroRemovedEvent(GuitarHeroRemovedEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIrEvent(IREvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMotionSensingEvent(MotionSensingEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNunchukInsertedEvent(NunchukInsertedEvent arg0)
	{
		JOptionPane.showMessageDialog(null, "Nunchucks are not Supported, please remove the nunchuck");	
	}

	@Override
	public void onNunchukRemovedEvent(NunchukRemovedEvent arg0)
	{
		JOptionPane.showMessageDialog(null, "Thankyou");
		
	}

	@Override
	public void onStatusEvent(StatusEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onButtonsEvent(WiimoteButtonsEvent arg0) {
		
	
		
		if(arg0.isButtonUpHeld())
			//level.moveLeft(arg0.getWiimoteId());
		
		if(arg0.isButtonDownPressed())
			level.setRight(true);
		if(arg0.isButtonDownJustReleased())
			level.setRight(false);
		
		if(arg0.isButtonLeftPressed())
			level.setDown(true);
		if(arg0.isButtonDownJustReleased())
			level.setDown(false);
		
		if(arg0.isButtonUpPressed())
			level.setLeft(true);
		if(arg0.isButtonDownJustReleased())
			level.setLeft(false);
		
		if(arg0.isButtonRightPressed())
			level.setUp(true);
		if(arg0.isButtonDownJustReleased())
			level.setUp(false);
		
	}
	
	public int getWiimotes()
	{
		return wiimotes.length;
	}

}
