package com.myfaculty.myapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DatabaseInfo {
	
	private JdbcTemplate template;

	public void setTamplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//CRUD Department Database
	public int insertDepartment (Department d){
		try{
			String insertDep = "INSERT INTO `department`(`Dep_Id`, `Dep_Name`) VALUES ( "
					+ d.getDepId()+" , '"+d.getDepName()+"' )";
			return template.update(insertDep);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int updateDepartment (Department d){
		try{
			String updateDep = "UPDATE `department` SET `Dep_Id`= "+d.getDepId()+
					" , `Dep_Name`= '"+d.getDepName()+"' WHERE `dep_Id`= "+d.getDepId();
			return template.update(updateDep);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int deleteDepartment (int depId){
		String deleteDep = null;
		try{
			deleteDep = "DELETE FROM `department` WHERE `dep_Id`= "+depId;
			return template.update(deleteDep);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}
	//select by id
	public Department departmentById (int depId){
		try{
			String sql1 = "SELECT * FROM `department` WHERE `dep_Id`= ?";
			return template.queryForObject(sql1, new Object[]{depId}, new BeanPropertyRowMapper<Department>(Department.class));
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return new Department();
	}

	public List<Department> viewAllDepartments(){
		try{
			String selectDep = "SELECT * FROM `department`";
			return template.query(selectDep, new RowMapper<Department>(){

				@Override
				public Department mapRow(ResultSet rs, int rownum) throws SQLException {
					Department d = new Department();
					d.setDepId(rs.getInt(1));
					d.setDepName(rs.getString(2));

					return d;
				}
			});
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return new ArrayList<Department>();
	}
	
	//CRUD Course Database
	public int insertCourses (Courses c){
		try{
			String insertCo = "INSERT INTO `courses`(`Co_Id`, `Co_Name`, `Co_Hours`, `Dep_Id`, `Ins_Id`) VALUES ( " +
					+ c.getCoId()+" , '"+c.getCoName()+"' , "+c.getCoHours() +" , "+c.getDepId()+" , "+c.getInsId()+" )";
			return template.update(insertCo);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int updateCourses (Courses c){
		try{
			String updateCo = "UPDATE `courses` SET `Co_Id`= "+c.getCoId()+" ,`Co_Name`= '"+c.getCoName()+"' ,"
					+ "`Co_Hours`= "+c.getCoHours()+" ,`Dep_Id`= "+c.getDepId()+" ,`Ins_Id`= "+c.getInsId()
					+ " WHERE `Co_Id`= "+c.getCoId();
			return template.update(updateCo);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int deleteCourses (int coId){
		try{
			String deleteCo = "DELETE FROM `courses` WHERE `Co_Id`= "+coId;
			return template.update(deleteCo);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public Courses coursesById (int coId){
		try{
			String sql2 = "SELECT * FROM `courses` WHERE `Co_Id`= ?";
			return template.queryForObject(sql2, new Object[]{coId}, new BeanPropertyRowMapper<Courses>(Courses.class));
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return new Courses();
	}

	public List<Courses> viewAllCourses (){
		try{
			String selectCo = "SELECT * FROM `courses`";
			return template.query(selectCo, new RowMapper<Courses>() {

				@Override
				public Courses mapRow(ResultSet rs, int rowNum) throws SQLException {
					Courses c = new Courses();
					c.setCoId(rs.getInt(1));
					c.setCoName(rs.getString(2));
					c.setCoHours(rs.getInt(3));
					c.setDepId(rs.getInt(4));
					c.setInsId(rs.getInt(5));

					return c;
				}
			});
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return new ArrayList<Courses>();
	}

	//CRUD Instructors Database
	public int insertInstructor (Instructors i){
		try{
			String insertIns = "INSERT INTO `instructor`(`Ins_Id`, `Ins_Name`, `Ins_Address`, `Ins_Phone`, `Ins_Salary`, `Dep_Id`) VALUES ( "
					+i.getInsId()+" , '"+i.getInsName()+"' , '"+i.getInsAddress()+"' , '"+i.getInsPhone()+"' , " +i.getInsSalary()+" , "+i.getDepId()+" )";
			return template.update(insertIns);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int updateInstructor (Instructors i){
		try{
			String updateIns = "UPDATE `instructor` SET `Ins_Id`= "+i.getInsId()+" ,`Ins_Name`= '"+i.getInsName()+"' ,"
					+ "`Ins_Address`= '"+i.getInsAddress()+"' ,`Ins_Phone`= '"+i.getInsPhone()+"' ,"
					+ "`Ins_Salary`= "+i.getInsSalary()+" ,`Dep_Id`= "+i.getDepId()
					+" WHERE `Ins_Id`= "+i.getInsId();
			return template.update(updateIns);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int deleteInstructor (int insId){
		try{
			String deleteIns = "DELETE FROM `instructor` WHERE `Ins_Id`= "+insId;
			return template.update(deleteIns);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public Instructors instructorById (int insId){
		try{
			String sql3 = "SELECT * FROM `instructor` WHERE `Ins_Id`= ?";
			return template.queryForObject(sql3, new Object[]{insId}, new BeanPropertyRowMapper<Instructors>(Instructors.class));
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return new Instructors();
	}

	public List<Instructors> viewAllInstructors (){
		try{
			String selectInstructor = "SELECT * FROM `instructor`";
			return template.query(selectInstructor, new RowMapper<Instructors>() {

				@Override
				public Instructors mapRow(ResultSet rs, int rowNum) throws SQLException {
					Instructors i = new Instructors();
					i.setInsId(rs.getInt(1));
					i.setInsName(rs.getString(2));
					i.setInsAddress(rs.getString(3));
					i.setInsPhone(rs.getString(4));
					i.setInsSalary(rs.getInt(5));
					i.setDepId(rs.getInt(6));

					return i;
				}
			});
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return new ArrayList<Instructors>();
	}

	//CRUD Student Database
	public int insertStudent (Students s){
		try{
			String InsertStud = "INSERT INTO `students`(`Stud_Id`, `Stud_Name`, `Stud_Address`, `Stud_Phone`, `Dep_Id`) VALUES ( "
					+ s.getStudId()+" , '"+s.getStudName()+"' , '"+s.getStudAddress()+"' , " + "'"+s.getStudPhone()+"' , "+s.getDepId()+" )";
			return template.update(InsertStud);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public int updateStudent (Students s){
		try{
			String updateStud = "UPDATE `students` SET `Stud_Id`= "+s.getStudId()+" ,`Stud_Name`= '"+s.getStudName()+"' ,"
					+ "`Stud_Address`= '"+s.getStudAddress()+"' ,`Stud_Phone`= '"+s.getStudPhone()+"' , "
					+ "`Dep_Id`= "+s.getDepId()+" WHERE `Stud_Id`= "+s.getStudId();
			return template.update(updateStud);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}
	public int deleteStudent (int studId){
		try{
			String deleteStud = "DELETE FROM `students` WHERE `Stud_Id`= "+studId;
			return template.update(deleteStud);
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return 0;
	}

	public Students studentById (int studId){
		try{
			String sql4 = "SELECT * FROM `students` WHERE `Stud_Id`= ?";
			return template.queryForObject(sql4, new Object[]{studId}, new BeanPropertyRowMapper<Students>(Students.class));
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return new Students();
	}

	public List<Students> viewAllStudents (){
		try{
			String selectStud = "SELECT * FROM `students`";
			return template.query(selectStud, new RowMapper<Students>() {

				@Override
				public Students mapRow(ResultSet rs, int rowNum) throws SQLException {
					Students s = new  Students();
					s.setStudId(rs.getInt(1));
					s.setStudName(rs.getString(2));
					s.setStudAddress(rs.getString(3));
					s.setStudPhone(rs.getString(4));
					s.setDepId(rs.getInt(5));

					return s;
				}
			});
		}catch(Exception e){
			System.out.println(e.toString());
		}
		return new ArrayList<Students>();
	}

}
