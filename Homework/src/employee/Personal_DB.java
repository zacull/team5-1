package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class Personal_DB implements Int_Personal_DB {
	private static String user = "ksj";
	private static String pw = "ksj";
	private static String url = "jdbc:oracle:thin:@192.168.0.15:1521:XE";

	private Connection conn = null;
	private Statement stmt = null;

	Personal_DB() {
		try {
			DriverManager.deregisterDriver(new OracleDriver());
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
		} catch (Exception e) {
			System.out.println("생성 실패");
		}

	}

	@Override
	public void setName(String emNum, String name) {
		try {
			String sql = "update personal set name = '" + name + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성 실패");
		}

	}

	@Override
	public void setId(String emNum, String id) {
		String[] idList = getId();
		boolean logical = true;

		go: while (logical) {
			for (String i : idList) {
				if (i.equals(id)) {
					System.out.println("동일한 ID가 존재합니다.\n 다시 입력해 주세요");
					logical = true;
					continue go;
				}
			}
			logical = false;

			try {
				String sql = "update personal set id = '" + id + "' where emNum = '" + emNum + "'";
				stmt.executeUpdate(sql);
			} catch (Exception e) {
				System.out.println("생성 실패");
			}
		}
	}

	@Override
	public void setPW(String emNum, String pw) {
		try {
			String sql = "update personal set pw = '" + pw + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성 실패");
		}

	}

	@Override
	public void setManage(String emNum, String manage) {
		// manage를 받을 때 y, n으로 저장한다.
		try {
			String sql = "update personal set manage = '" + manage + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성 실패");
		}

	}

	@Override
	public void setEmNum(String id, String emNum) {
		try {
			String sql = "update personal set emNum = '" + emNum + "' where id = '" + id + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

	@Override
	public void createEmNum(String emNum, String id) {
		try {
			String sql = "insert into personal(emnum,id) values('" + emNum + "'" + ",'" + id + "')";
			stmt.executeUpdate(sql);

			sql = "insert into wage(emnum) values('" + emNum + "')";
			stmt.executeUpdate(sql);

			System.out.println("사원을 생성하였습니다.");
		} catch (SQLException e) {
			System.out.println("사원을 생성하지 못하였습니다.");
		}

	}

	@Override
	public void setBirth(String emNum, int birth) {
		try {
			String sql = "update personal set birth = '" + birth + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성 실패");
		}

	}

	@Override
	public void setSex(String emNum, String sex) {
		try {

			String sql = "update personal set sex = '" + sex + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

	@Override
	public void setStaD(String emNum, int staD) {
		try {
			String sql = "update personal set stad = '" + staD + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

	@Override
	public void setLevel(String emNum, String level) {
		try {
			String sql = "update personal set lev = '" + level + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

	@Override
	public void setGroup(String emNum, String group) {
		try {

			String sql = "update personal set gro = '" + group + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

	@Override
	public void setEMail(String emNum, String eMail) {
		try {
			String sql = "update personal set email = '" + eMail + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

	@Override
	public void setAddress(String emNum, String address) {
		try {
			String sql = "update personal set address = '" + address + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

	@Override
	public void setPhone(String emNum, String phone) {
		try {
			String sql = "update personal set phone = '" + phone + "' where emNum = '" + emNum + "'";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println("생성 실패");
		}
	}

	@Override
	public String[] getId() {
		String[] idArray = null;
		try {

			String sql = "select count(*) from personal";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			int size = result.getInt(1);

			idArray = new String[size];

			sql = "select id from personal";
			result = stmt.executeQuery(sql);

			while (result.next()) {
				idArray[result.getRow() - 1] = result.getString("id");
			}

		} catch (Exception e) {
			System.out.println("실패");
		}
		return idArray;
	}

	@Override
	public String[] getEmNum() {

		String[] emNumArray = null;
		try {

			String sql = "select count(*) from personal";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			int size = result.getInt(1);

			emNumArray = new String[size];

			sql = "select emnum from personal";
			result = stmt.executeQuery(sql);

			while (result.next()) {
				emNumArray[result.getRow() - 1] = result.getString(1);
			}

		} catch (Exception e) {
			System.out.println("실패");
		}
		return emNumArray;
	}

	@Override
	public String[] getName() {
		String[] nameArray = null;
		try {
			String sql = "select count(*) from personal";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			int size = result.getInt(1);

			nameArray = new String[size];

			sql = "select name from personal";
			result = stmt.executeQuery(sql);

			while (result.next()) {
				nameArray[result.getRow() - 1] = result.getString(1);
			}

		} catch (Exception e) {
			System.out.println("실패");
		}
		return nameArray;
	}

	@Override
	public String getName(String emNum) {
		String name = null;
		try {
			String sql = "select name from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			name = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return name;
	}

	@Override
	public String getId(String emNum) {
		String id = null;
		try {
			String sql = "select id from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			id = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return id;
	}

	@Override
	public String getPW(String emNum) {
		String pw = null;
		try {
			String sql = "select pw from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			pw = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return pw;

	}

	@Override
	public boolean getManage(String emNum) {
		String manage = null;
		try {
			String sql = "select manage from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			manage = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		if (manage.equals("y")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getEmNum(String id) {
		String emnum = null;
		try {

			String sql = "select emnum from personal where id = '" + id + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			emnum = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return emnum;
	}

	@Override
	public int getBirth(String emNum) {
		int birth = 0;
		try {
			String sql = "select birth from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			birth = result.getInt(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return birth;
	}

	@Override
	public String getSex(String emNum) {
		String sex = null;
		try {
			String sql = "select sex from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			sex = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return sex;
	}

	@Override
	public int getStaD(String emNum) {
		int stad = 0;
		try {
			String sql = "select stad from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			stad = result.getInt(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return stad;

	}

	@Override
	public String getLevel(String emNum) {
		String level = null;

		try {
			String sql = "select lev from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			level = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return level;
	}

	@Override
	public String getGroup(String emNum) {
		String group = null;
		try {
			String sql = "select grp from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			group = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return group;
	}

	@Override
	public String getEMail(String emNum) {
		String eMail = null;
		try {
			String sql = "select email from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			eMail = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return eMail;
	}

	@Override
	public String getAddress(String emNum) {
		String address = null;
		try {
			String sql = "select address from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			address = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return address;
	}

	@Override
	public String getPhone(String emNum) {
		String phone = null;
		try {
			String sql = "select phont from personal where emnum = '" + emNum + "'";
			ResultSet result = stmt.executeQuery(sql);

			result.next();
			phone = result.getString(1);

		} catch (Exception e) {
			System.out.println("실패");
		}
		return phone;
	}

	@Override
	public void delete(String emNum) {
		try {
			String sql = "delete from personal where emnum = '" + emNum + "'";
			stmt.executeUpdate(sql);

			sql = "delete from wage where emnum = '" + emNum + "'";
			stmt.executeUpdate(sql);

			System.out.println("삭제가 완료되었습니다.");

		} catch (SQLException e) {
			System.out.println("삭제에 실패하였습니다.");
		}
	}

}
