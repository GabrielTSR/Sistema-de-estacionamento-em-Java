package br.com.CelsoParking;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.CelsoParking.gui.FrameEstacionamento;

public class App {

	public static void main(String[] args) {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
			UIManager.setLookAndFeel(info.getClassName());
			break;
			}
			}
			} catch (UnsupportedLookAndFeelException e) {
			// handle exception
			} catch (ClassNotFoundException e) {
			// handle exception
			} catch (InstantiationException e) {
			// handle exception
			} catch (IllegalAccessException e) {
			// handle exception
			}
		
		
		FrameEstacionamento telaEstacionamento = new FrameEstacionamento();
		
		telaEstacionamento.criarTela();

		

	}

}
