package br.com.CelsoParking.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import br.com.CelsoParking.dao.MovimentoDao;
import br.com.CelsoParking.model.Movimento;
import br.com.CelsoParking.model.Veiculo;
import br.com.CelsoParking.util.Util;

public class FrameEstacionamento {

	private JLabel labelEntrada;
	private JLabel labelPlacaEntrada;
	private JTextField textPlacaEntrada;
	private JLabel labelModeloEntrada;
	private JTextField textModeloEntrada;
	private JButton buttonEntrar;
	private JScrollPane scrollTable;
	private JTable tabelaMovimentos;
	private DefaultTableModel tabelaMovimentosModelo;
	private JLabel labelSaida;
	private JLabel labelPlacaSaida;
	private JTextField textPlacaSaida;
	private JButton buttonBuscar;
	private JLabel labelSegundoModelo;
	private JTextField textModeloSaida;
	private JLabel labelDataEntrada;
	private JTextField textDataEntrada;
	private JLabel labelHoraEntrada;
	private JTextField textHoraEntrada;
	private JLabel labelDataSaida;
	private JTextField textDataSaida;
	private JLabel labelHoraSaida;
	private JTextField textHoraSaida;
	private JLabel labelTempo;
	private JTextField textTempo;
	private JLabel labelValorAPagar;
	private JTextField textValorAPagar;
	private JButton buttonEfetuarSaida;
	private JButton buttonFecharSistema;

	public void criarTela() {

		Color colorFundo = new Color(19, 28, 33);
		Color colorTitulo = Color.WHITE;
		Color colorLableText = Color.WHITE;
		Color colorCaixa = new Color(12, 136, 124);
		Color colorButton = new Color(51, 56, 59);
		Font fontTitulo = new Font("BCopperplate Gothic", Font.BOLD, 30);
		Font fontLableText = new Font("BCopperplate Gothic", Font.PLAIN, 15);
		Font fontTextoCaixa = new Font("BCopperplate Gothic", Font.BOLD, 15);

		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Celso parking");
		tela.setSize(1050, 730);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		tela.getContentPane().setBackground(colorFundo);

		labelEntrada = new JLabel("ENTRADA");
		labelEntrada.setBounds(40, 20, 200, 30);
		labelEntrada.setFont(fontTitulo);
		labelEntrada.setForeground(colorTitulo);

		labelPlacaEntrada = new JLabel("PLACA:");
		labelPlacaEntrada.setBounds(40, 80, 100, 30);
		labelPlacaEntrada.setForeground(colorTitulo);
		labelPlacaEntrada.setFont(fontLableText);

		textPlacaEntrada = new JTextField();
		textPlacaEntrada.setBounds(20, 110, 300, 30);
		textPlacaEntrada.setForeground(colorLableText);
		textPlacaEntrada.setBackground(colorCaixa);
		textPlacaEntrada.setFont(fontTextoCaixa);

		labelModeloEntrada = new JLabel("MODELO:");
		labelModeloEntrada.setBounds(370, 80, 100, 30);
		labelModeloEntrada.setForeground(colorTitulo);
		labelModeloEntrada.setFont(fontLableText);

		textModeloEntrada = new JTextField();
		textModeloEntrada.setBounds(350, 110, 300, 30);
		textModeloEntrada.setForeground(colorLableText);
		textModeloEntrada.setBackground(colorCaixa);
		textModeloEntrada.setFont(fontTextoCaixa);

		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(660, 100, 150, 45);
		buttonEntrar.setForeground(colorLableText);
		buttonEntrar.setBackground(colorButton);
		buttonEntrar.setFont(fontTextoCaixa);

		labelSaida = new JLabel("SAÍDA");
		labelSaida.setBounds(40, 400, 130, 40);
		labelSaida.setFont(fontTitulo);
		labelSaida.setForeground(colorTitulo);

		labelPlacaSaida = new JLabel("PLACA:");
		labelPlacaSaida.setBounds(40, 440, 100, 30);
		labelPlacaSaida.setForeground(colorTitulo);
		labelPlacaSaida.setFont(fontLableText);

		textPlacaSaida = new JTextField();
		textPlacaSaida.setBounds(20, 470, 180, 30);
		textPlacaSaida.setForeground(colorLableText);
		textPlacaSaida.setBackground(colorCaixa);
		textPlacaSaida.setFont(fontTextoCaixa);

		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(220, 460, 150, 45);
		buttonBuscar.setForeground(colorLableText);
		buttonBuscar.setBackground(colorButton);
		buttonBuscar.setFont(fontTextoCaixa);

		labelSegundoModelo = new JLabel("MODELO:");
		labelSegundoModelo.setBounds(40, 510, 100, 30);
		labelSegundoModelo.setForeground(colorTitulo);
		labelSegundoModelo.setFont(fontLableText);

		textModeloSaida = new JTextField();
		textModeloSaida.setBounds(20, 540, 180, 30);
		textModeloSaida.setForeground(colorLableText);
		textModeloSaida.setBackground(colorCaixa);
		textModeloSaida.setFont(fontTextoCaixa);
		textModeloSaida.setEnabled(false);

		labelDataEntrada = new JLabel("DATA ENTRADA:");
		labelDataEntrada.setBounds(230, 510, 130, 30);
		labelDataEntrada.setForeground(colorTitulo);
		labelDataEntrada.setFont(fontLableText);

		textDataEntrada = new JTextField();
		textDataEntrada.setBounds(210, 540, 150, 30);
		textDataEntrada.setForeground(colorLableText);
		textDataEntrada.setBackground(colorCaixa);
		textDataEntrada.setFont(fontTextoCaixa);
		textDataEntrada.setEnabled(false);

		labelHoraEntrada = new JLabel("HORA ENTRADA:");
		labelHoraEntrada.setBounds(390, 510, 130, 30);
		labelHoraEntrada.setForeground(colorTitulo);
		labelHoraEntrada.setFont(fontLableText);

		textHoraEntrada = new JTextField();
		textHoraEntrada.setBounds(370, 540, 150, 30);
		textHoraEntrada.setForeground(colorLableText);
		textHoraEntrada.setBackground(colorCaixa);
		textHoraEntrada.setFont(fontTextoCaixa);
		textHoraEntrada.setEnabled(false);

		labelDataSaida = new JLabel("DATA SAÍDA:");
		labelDataSaida.setBounds(550, 510, 130, 30);
		labelDataSaida.setForeground(colorTitulo);
		labelDataSaida.setFont(fontLableText);

		textDataSaida = new JTextField();
		textDataSaida.setBounds(530, 540, 150, 30);
		textDataSaida.setForeground(colorLableText);
		textDataSaida.setBackground(colorCaixa);
		textDataSaida.setFont(fontTextoCaixa);
		textDataSaida.setEnabled(false);

		labelHoraSaida = new JLabel("HORA SAÍDA:");
		labelHoraSaida.setBounds(710, 510, 130, 30);
		labelHoraSaida.setForeground(colorTitulo);
		labelHoraSaida.setFont(fontLableText);

		textHoraSaida = new JTextField();
		textHoraSaida.setBounds(690, 540, 150, 30);
		textHoraSaida.setForeground(colorLableText);
		textHoraSaida.setBackground(colorCaixa);
		textHoraSaida.setFont(fontTextoCaixa);
		textHoraSaida.setEnabled(false);

		labelTempo = new JLabel("TEMPO (MINUTOS):");
		labelTempo.setBounds(860, 510, 150, 30);
		labelTempo.setForeground(colorTitulo);
		labelTempo.setFont(fontLableText);

		textTempo = new JTextField();
		textTempo.setBounds(850, 540, 150, 30);
		textTempo.setForeground(colorLableText);
		textTempo.setBackground(colorCaixa);
		textTempo.setFont(fontTextoCaixa);
		textTempo.setEnabled(false);

		labelValorAPagar = new JLabel("VALOR A PAGAR:");
		labelValorAPagar.setBounds(40, 640, 130, 30);
		labelValorAPagar.setForeground(colorTitulo);
		labelValorAPagar.setFont(fontLableText);

		textValorAPagar = new JTextField();
		textValorAPagar.setBounds(200, 610, 200, 80);
		textValorAPagar.setForeground(colorLableText);
		textValorAPagar.setBackground(colorButton);
		textValorAPagar.setFont(new Font("CONSOLAS", Font.BOLD, 35));
		textValorAPagar.setEnabled(false);

		buttonEfetuarSaida = new JButton("EFETUAR SAÍDA");
		buttonEfetuarSaida.setBounds(420, 610, 210, 80);
		buttonEfetuarSaida.setForeground(colorLableText);
		buttonEfetuarSaida.setBackground(colorButton);
		buttonEfetuarSaida.setFont(new Font("BCopperplate Gothic", Font.BOLD, 21));
		buttonEfetuarSaida.setEnabled(false);

		buttonFecharSistema = new JButton("FECHAR SISTEMA");
		buttonFecharSistema.setBounds(650, 610, 230, 80);
		buttonFecharSistema.setForeground(Color.WHITE);
		buttonFecharSistema.setBackground(Color.RED);
		buttonFecharSistema.setFont(new Font("BCopperplate Gothic", Font.BOLD, 21));

		criarTabela();
		scrollTable = new JScrollPane(tabelaMovimentos);
		scrollTable.setBounds(20, 150, 850, 250);

		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(labelPlacaEntrada);
		tela.getContentPane().add(textPlacaEntrada);
		tela.getContentPane().add(labelModeloEntrada);
		tela.getContentPane().add(textModeloEntrada);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelPlacaSaida);
		tela.getContentPane().add(textPlacaSaida);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(labelSegundoModelo);
		tela.getContentPane().add(textModeloSaida);
		tela.getContentPane().add(labelDataEntrada);
		tela.getContentPane().add(textDataEntrada);
		tela.getContentPane().add(labelHoraEntrada);
		tela.getContentPane().add(textHoraEntrada);
		tela.getContentPane().add(labelDataSaida);
		tela.getContentPane().add(textDataSaida);
		tela.getContentPane().add(labelHoraSaida);
		tela.getContentPane().add(textHoraSaida);
		tela.getContentPane().add(labelTempo);
		tela.getContentPane().add(textTempo);
		tela.getContentPane().add(labelValorAPagar);
		tela.getContentPane().add(textValorAPagar);
		tela.getContentPane().add(buttonEfetuarSaida);
		tela.getContentPane().add(buttonFecharSistema);
		tela.getContentPane().add(scrollTable);

		tela.setVisible(true);

		buttonEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validarFormulario()) {

					Movimento movimento = new Movimento();
					Veiculo veiculo = new Veiculo();
					movimento.setVeiculo(veiculo);
					
					movimento.setCodigo(Util.gerarCodigo().toUpperCase());
					veiculo.setPlaca(textPlacaEntrada.getText().toUpperCase().replaceAll(" ",""));
					veiculo.setModelo(textModeloEntrada.getText().toUpperCase().trim());
					movimento.setTempoEntrada(LocalDateTime.now());
					movimento.setDataEntradaContainer();
					movimento.setHoraEntradaContainer();
					movimento.setPago(false);

					MovimentoDao dao = new MovimentoDao(movimento);
					dao.salvar();

					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!");

					limparFormulario();
					criarTabela();
					

				} else {
					JOptionPane.showMessageDialog(null, "Você deve preencher os campos obrigatórios!", "Atenção!",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		buttonBuscar.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				if (validarBusca()) {

					String placa;
					placa = textPlacaSaida.getText();
					
					
					MovimentoDao dao = new MovimentoDao();
					
					try {
						
						labelPlacaSaida.setForeground(Color.WHITE);
						Movimento movimento = dao.buscarMovimento(placa);
						
						textModeloSaida.setText(movimento.getVeiculo().getModelo());
						textDataEntrada.setText(movimento.getDataEntradaContainer());
						textHoraEntrada.setText(movimento.getHoraEntradaContainer());
						textDataSaida.setText(movimento.getDataSaidaContainer());
						textHoraSaida.setText(movimento.getHoraSaidaContainer());
						textValorAPagar.setText("R$" + String.valueOf(movimento.getValorAPagar()).replaceAll("\\.", ","));
						textTempo.setText(String.valueOf(movimento.getMinutosGastos()));
						
						buttonEfetuarSaida.setEnabled(true);
						
						buttonEfetuarSaida.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								
								try {
									movimento.setPago(true);
									MovimentoDao dao = new MovimentoDao(movimento);
									dao.salvar();
									
									JOptionPane.showMessageDialog(null, "Pagamento bem-sucedido!");
									limparFormulario();
									criarTabela();
									
									
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(null, "Não foi possível realizar o pagamento!");
								}
								
							}
						});
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Não encontramos a placa digitada, verifique se digitou corretamente!", "OPS!",
								JOptionPane.WARNING_MESSAGE);
						labelPlacaSaida.setForeground(Color.RED);
					}
					
					

					
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Você deve preencher os campos obrigatórios!", "Atenção!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		buttonFecharSistema.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	private void criarTabela() {

		tabelaMovimentosModelo = new DefaultTableModel();

		tabelaMovimentosModelo.addColumn("CÓDIGO");
		tabelaMovimentosModelo.addColumn("PLACA");
		tabelaMovimentosModelo.addColumn("MODELO");
		tabelaMovimentosModelo.addColumn("DATA ENTRADA");
		
		MovimentoDao movimentoDao = new MovimentoDao();
		ArrayList<Movimento> movimentos = movimentoDao.listarMovimentos();
		
		
		
		for (Movimento movimento : movimentos) {
			
			

			String[] vetorMovimento = {
					
					movimento.getCodigo(), 
					movimento.getVeiculo().getPlaca(),
					movimento.getVeiculo().getModelo(),
					movimento.getDataEntradaContainer()};
			
			tabelaMovimentosModelo.addRow(vetorMovimento);
		}

		tabelaMovimentos = new JTable(tabelaMovimentosModelo);

		tabelaMovimentos.getColumnModel().getColumn(0).setPreferredWidth(90);
		tabelaMovimentos.getColumnModel().getColumn(1).setPreferredWidth(90);
		tabelaMovimentos.getColumnModel().getColumn(2).setPreferredWidth(90);
		tabelaMovimentos.getColumnModel().getColumn(3).setPreferredWidth(90);

		tabelaMovimentos.getColumnModel().getColumn(0).setResizable(false);
		tabelaMovimentos.getTableHeader().setReorderingAllowed(false);

	}

	private void limparFormulario() {
		textPlacaEntrada.setText("");
		textModeloEntrada.setText("");
		textPlacaSaida.setText("");
		textModeloSaida.setText("");
		textDataEntrada.setText("");
		textHoraEntrada.setText("");
		textDataSaida.setText("");
		textHoraSaida.setText("");
		textValorAPagar.setText("");
		textPlacaSaida.requestFocus();
	}

	private boolean validarFormulario() {

		boolean valido = true;

		if (textPlacaEntrada.getText().trim().length() == 0) {
			labelPlacaEntrada.setForeground(Color.RED);
			return valido = false;
		} else if (textModeloEntrada.getText().trim().length() == 0) {
			labelPlacaEntrada.setForeground(Color.WHITE);
			labelModeloEntrada.setForeground(Color.RED);
			return valido = false;
		}
		labelPlacaEntrada.setForeground(Color.WHITE);
		labelModeloEntrada.setForeground(Color.WHITE);
		return valido;
	}

	private boolean validarBusca() {

		boolean valido = true;

		if (textPlacaSaida.getText().trim().length() == 0) {
			labelPlacaSaida.setForeground(Color.RED);
			valido = false;
		}
		return valido;
	}

}
