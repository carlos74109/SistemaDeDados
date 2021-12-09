package Banco_Dados;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Crud {
	
	public static Connection conexao () {
		
		try {
			String url = "jdbc:mysql://localhost/projeto";
			String user = "root";
			String senha = "CARlos799";
			
			return DriverManager.getConnection(url, user, senha);
		}catch(Exception e) {
			throw new RuntimeException(e);
			
		}
	
	}
	
	public void inserirDados(String nome, String idade, String profissao) {
		String sql = "insert into pessoa(nome, idade, profissao) values (?, ?, ?)";
		
		try {
			Connection conn = conexao();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, nome);
			pst.setString(2, idade);
			pst.setString(3, profissao);
			pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void buscarDado() {
		String sql = "select * from pessoa";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String profissao = rs.getString(4);
			
				System.out.println("Id: "+id+", " + " Nome: " + nome+ ", " + " Idade: " + idade +", " + " Profissão: " + profissao );
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void editarDados(String nome, String idade, String profissao, int id) {
		String sql = "update pessoa set nome = ?, idade = ?, profissao = ? where id = ? ";
		
		try {
			Connection conn = conexao();
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, nome);
			pst.setString(2, idade);
			pst.setString(3, profissao);
			pst.setInt(4, id);
			
			pst.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void buscarDadoExpecifico(int idC) {
		String sql = "select * from pessoa where id = ?";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			//ResultSet rs = pst.executeQuery();
			pst.setInt(1, idC);
			pst.executeUpdate();
			
			
			System.out.println("ok");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void excluirDado(int id) {
		String sql = "delete from pessoa where id = ?";
		try {
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public void buscarDadoTxt() {
		String sql = "select * from pessoa";
		File diretorio = new File("C:\\CursoJava\\ProjetoModuloJDBC\\src\\diretorioTxt");
		//diretorio.mkdir();
		try {
			
			FileWriter arquivoTxt = new FileWriter(diretorio.getAbsolutePath()+"\\" + "dados.txt");
			
			PrintWriter escreverDados = new PrintWriter(arquivoTxt);
			
			Connection conn = conexao();
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String profissao = rs.getString(4);
			
				escreverDados.println("Id: " + id);
				escreverDados.println("Nome: "+ nome);
				escreverDados.println("Idade: " + idade);
				escreverDados.println("Profissão: " + profissao);
				escreverDados.println("//////////////");
			}
			escreverDados.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
