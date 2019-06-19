package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class Wage_DB implements Int_Wage_DB{
	private static String user = "ksj";
	private static String pw = "ksj";
	private static String url = "jdbc:oracle:thin:@192.168.0.15:1521:XE";

	private Connection conn = null;
	private Statement stmt = null;

	Wage_DB(){
		try {
			DriverManager.deregisterDriver(new OracleDriver());
			conn = DriverManager.getConnection(url,user,pw);
			stmt = conn.createStatement();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void setBasicM(String emNum, int basicM) {

		try {
			String sql ="update wage set basicm = '" + basicM + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);			
		} catch (Exception e) {
			System.out.println("생성실패");
		}
	}

	@Override
	public void setLevelM(String emNum, int levelM) {
		try {
			String sql ="update wage set levelm = '" + levelM + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("생성실패");
		}
	}

	@Override
	public void setEatM(String emNum, int eatM) {

		try {
			String sql ="update wage set eatm = '" + eatM + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("생성실패");
		}
	}

	@Override
	public void setTimeM(String emNum, int timeM) {

		try {	
			String sql ="update wage set timem = '" + timeM + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성실패");
		}
	}

	@Override
	public void setReTax(String emNum, int reTax) {

		try {	
			String sql ="update wage set retax = '" + reTax + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성실패");
		}
	}

	@Override
	public void setEmTax(String emNum, int emTax) {

		try {	
			String sql ="update wage set emtax = '" + emTax + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성실패");
		}
	}

	@Override
	public int getBasicM(String emNum) {
		int basicM = 0;
		try {	
			String sql = "select basicm from wage where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			basicM = result.getInt(1);
		} catch (Exception e) {
			System.out.println("실패");
		}
		return basicM;
	}

	@Override
	public int getLevelM(String emNum) {
		int levelM= 0;
		try {	
			String sql = "select levelm from wage where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			levelM = result.getInt(1);
		} catch (Exception e) {
			System.out.println("실패");
		}
		return levelM;
	}

	@Override
	public int getEatM(String emNum) {
		int eatM = 0;
		try {	
			String sql = "select eatm from wage where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);
			
			result.next();
			eatM = result.getInt(1);
		} catch (Exception e) {
			System.out.println("실패");
		}
		return eatM;
	}

	@Override
	public int getTimeM(String emNum) {
		int timeM = 0;
		try {	
			String sql = "select timem from wage where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);
			
			result.next();
			timeM = result.getInt(1);
		} catch (Exception e) {
			System.out.println("실패");
		}
		return timeM;
	}

	@Override
	public int getReTax(String emNum) {
		int reTax =0;
		try {	
			String sql = "select retax from wage where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);
			
			result.next();
			reTax = result.getInt(1);
		} catch (Exception e) {
			System.out.println("실패");
		}
		return reTax;
	}

	@Override
	public int getEmTax(String emNum) {
		int emTax =0;
		try {	
			String sql = "select emtax from wage where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);
			
			result.next();
			emTax = result.getInt(1);
		} catch (Exception e) {
			System.out.println("실패");
		}
		return emTax;
	}

	@Override
	public String[] getEmNum() {
		String[] emNumArray = null;
		try {	
			String sql = "select count(*) from wage";
			ResultSet result = stmt.executeQuery(sql);
			
			result.next();
			int size = result.getInt(1);
			
			emNumArray = new String[size];
			
			sql = "select emnum from wage";
			result = stmt.executeQuery(sql);
			
			while(result.next()) {
				emNumArray[result.getRow()-1] = result.getString(1);
			}
			
		} catch (Exception e) {
			System.out.println("실패");
		}
		return emNumArray;
	}

	@Override
	public int getHealth(String emNum) {

		try {	
		} catch (Exception e) {
			System.out.println("실패");
		}
			return (int)(getOriginM(emNum)*0.06);
	}

	@Override
	public int getNaPen(String emNum) {

		try {	
		} catch (Exception e) {
			System.out.println("실패");
		}
		return (int)(getOriginM(emNum)*0.1);
	}

	@Override
	public int getOriginM(String emNum) {
		int sum = 0;

		try {	
			
			sum += getBasicM(emNum);
			sum += getLevelM(emNum);
			sum += getEatM(emNum);
			sum += getTimeM(emNum);
			
		} catch (Exception e) {
			System.out.println("실패");
		}
		return sum;
	}

	@Override
	public int getMinusM(String emNum) {
			int sum = 0;
		try {	
			
			
			sum += getReTax(emNum);
			sum += getEmTax(emNum);
			sum += getHealth(emNum);
			sum += getNaPen(emNum);
			
		} catch (Exception e) {
			System.out.println("실패");
		}
		return sum;
	}

	@Override
	public int getRealM(String emNum) {

		try {	
		} catch (Exception e) {
			System.out.println("실패");
		}
			return getOriginM(emNum) - getMinusM(emNum);
	}



}
