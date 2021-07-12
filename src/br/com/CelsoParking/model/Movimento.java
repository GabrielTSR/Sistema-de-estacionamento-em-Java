package br.com.CelsoParking.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Movimento {
	private String codigo;
	private Veiculo veiculo;
	private LocalDateTime tempoEntrada;
	private String dataEntradaContainer;
	private String horaEntradaContainer;
	private LocalDateTime tempoSaida;
	private String dataSaidaContainer;
	private String horaSaidaContainer;
	private boolean pago = false;
	private double valorAPagar;
	private double valorPrimeiraHora = 10;
	private double valorDemaisHoras = 5;
	private double horasGastas;
	private double minutosGastos;
	
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public LocalDateTime getTempoEntrada() {
		return tempoEntrada;
	}
	public void setTempoEntrada(LocalDateTime tempoEntrada) {
		this.tempoEntrada = tempoEntrada;
	}
	public void setDataEntradaContainer(String dataEntradaContainer) {
		this.dataEntradaContainer = dataEntradaContainer;
	}
	public void setHoraEntradaContainer(String horaEntradaContainer) {
		this.horaEntradaContainer = horaEntradaContainer;
	}
	public void setDataSaidaContainer(String dataSaidaContainer) {
		this.dataSaidaContainer = dataSaidaContainer;
	}
	public void setHoraSaidaContainer(String horaSaidaContainer) {
		this.horaSaidaContainer = horaSaidaContainer;
	}
	public String getDataEntradaContainer() {
		return dataEntradaContainer;
	}
	public void setDataEntradaContainer() {
		this.dataEntradaContainer = String.valueOf(this.tempoEntrada.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	public String getHoraEntradaContainer() {
		return horaEntradaContainer;
	}
	public void setHoraEntradaContainer() {
		this.horaEntradaContainer = String.valueOf(this.tempoEntrada.format(DateTimeFormatter.ofPattern("HH:mm")));
	}
	public LocalDateTime getTempoSaida() {
		return tempoSaida;
	}
	public void setTempoSaida(LocalDateTime tempoSaida) {
		this.tempoSaida = tempoSaida;
	}
	public String getDataSaidaContainer() {
		return dataSaidaContainer;
	}
	public void setDataSaidaContainer() {
		this.dataSaidaContainer = String.valueOf(this.tempoSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	public String getHoraSaidaContainer() {
		return horaSaidaContainer;
	}
	public void setHoraSaidaContainer() {
		this.horaSaidaContainer = String.valueOf(this.tempoSaida.format(DateTimeFormatter.ofPattern("HH:mm")));
	}
	public double getHorasGastas() {
		LocalDateTime horaEntradaLocalDateTime = LocalDateTime.parse(this.dataEntradaContainer + " " + this.horaEntradaContainer, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		// 06/07/2021 11:24
		
		LocalDateTime horaSaidaLocalDateTime = LocalDateTime.parse(this.dataSaidaContainer + " " + this.horaSaidaContainer, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		double horasGastas = ChronoUnit.HOURS.between(horaEntradaLocalDateTime, horaSaidaLocalDateTime);
		double minutosGastos = ChronoUnit.MINUTES.between(horaEntradaLocalDateTime, horaSaidaLocalDateTime);
		
		this.minutosGastos = minutosGastos;
		this.horasGastas = horasGastas;
		
		return horasGastas;
	}
	public double getMinutosGastos() {
		return minutosGastos;
	}
	public double getValorAPagar() {
		
		double valorAPagar = (getHorasGastas() * this.valorDemaisHoras) + this.valorPrimeiraHora; 
		
		this.valorAPagar = valorAPagar;
		
		return valorAPagar;
	}
	public double getValorPrimeiraHora() {
		return valorPrimeiraHora;
	}
	public void setValorPrimeiraHora(double valorPrimeiraHora) {
		this.valorPrimeiraHora = valorPrimeiraHora;
	}
	public double getValorDemaisHoras() {
		return valorDemaisHoras;
	}
	public void setValorDemaisHoras(double valorDemaisHoras) {
		this.valorDemaisHoras = valorDemaisHoras;
	}
	
	@Override
	public String toString() {
		return veiculo.getPlaca() 
				+ ";" + codigo 
				+ ";" + veiculo.getModelo() 
				+ ";" + dataEntradaContainer 
				+ ";" + horaEntradaContainer 
				+ ";" + dataSaidaContainer 
				+ ";" + horaSaidaContainer 
				+ ";" + horasGastas 
				+ ";" + valorAPagar 
				+ ";" + isPago();
	}
	
}
