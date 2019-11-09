package com.myfaculty.myapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DatabaseInfo {
	
	private JdbcTemplate tamplate;

	public void setTamplate(JdbcTemplate tamplate) {
		this.tamplate = tamplate;
	}
	
	//CRUD Department Database
	public int insertDepartment (Department d){
		String insertDep = "INSERT INTO `department`(`Dep_Id`, `Dep_Name`)"
				           +" VALUES ( "+d.getDepId()+" , '"+d.getDepName()+"' )";
		return tamplate.update(insertDep);
	}
	public int updateDepartment (Department d){
		String updateDep = "UPDATE `department` SET `Dep_Id`= "+d.getDepId()+
				           " , `Dep_Name`= '"+d.getDepName()+"' WHERE `dep_Id`= "+d.getDepId();
		return tamplate.update(updateDep);
	}
	public int deleteDepartment (int depId){
		String deleteDep = "DELETE FROM `department` WHERE `dep_Id`= "+depId;
		return tamplate.update(deleteDep);
	}
	//select by id
	public Department departmentById (int depId){
		String sql1 = "SELECT * FROM `department` WHERE `dep_Id`= ?";
		return tamplate.queryForObject(sql1, new Object[]{depId}, new BeanPropertyRowMapper<Department>(Department.class));
	}
	public List<Department> viewAllDepartments(){
		String selectDep = "SELECT * FROM `department`";
		return tamplate.query(selectDep, new RowMapper<Department>(){

			@Override
			public Department mapRow(ResultSet rs, int rownum) throws SQLException {
			Department d = new Department();
			d.setDepId(rs.getInt(1));
			d.setDepName(rs.getString(2));
			
			return d;
		}
		});
		}
	
	//CRUD Course Database
	public int insertCourses (Courses c){
		String insertCo = "INSERT INTO `courses`(`Co_Id`, `Co_Name`, `Co_Hours`, `Dep_Id`, `Ins_Id`)"
				           +" VALUES ( "+c.getCoId()+" , '"+c.getCoName()+"' , "+c.getCoHours()
			           	   +" , "+c.getDepId()+" , "+c.getInsId()+" )";
		return tamplate.update(insertCo);
	}
	public int updateCourses (Courses c){
		String updateCo = "UPDATE `courses` SET `Co_Id`= "+c.getCoId()+" ,`Co_Name`= '"+c.getCoName()+"' ,"
				        + "`Co_Hours`= "+c.getCoHours()+" ,`Dep_Id`= "+c.getDepId()+" ,`Ins_Id`= "+c.getInsId()
				        + " WHERE `Co_Id`= "+c.getCoId();
		return tamplate.update(updateCo);
	}
	public int deleteCourses (int coId){
		String deleteCo = "DELETE FROM `courses` WHERE `Co_Id`= "+coId;
		return tamplate.update(deleteCo);
	}
	public Courses coursesById (int coId){
		String sql2 = "SELECT * FROM `courses` WHERE `Co_Id`= ?";
		return tamplate.queryForObject(sql2, new Object[]{coId}, new BeanPropertyRowMapper<Courses>(Courses.class));
	}
	public List<Courses> viewAllCourses (){
		String selectCo = "SELECT * FROM `courses`";
		return tamplate.query(selectCo, new RowMapper<Courses>() {

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
	}
	//CRUD Instructors Database
	public int insertInstructor (Instructors i){
		String insertIns = "INSERT INTO `instructor`(`Ins_Id`, `Ins_Name`, `Ins_Address`, `Ins_Phone`, `Ins_Salary`, `Dep_Id`)"
				+ " VALUES ( "+i.getInsId()+" , '"+i.getInsName()+"' , '"+i.getInsAddress()+"' , '"+i.getInsPhone()+"' , "
				+i.getInsSalary()+" , "+i.getDepId()+" )";
		return tamplate.update(insertIns);
	}
	public int updateInstructor (Instructors i){
		String updateIns = "UPDATE `instructor` SET `Ins_Id`= "+i.getInsId()+" ,`Ins_Name`= '"+i.getInsName()+"' ,"
				         + "`Ins_Address`= '"+i.getInsAddress()+"' ,`Ins_Phone`= '"+i.getInsPhone()+"' ,"
				         + "`Ins_Salary`= "+i.getInsSalary()+" ,`Dep_Id`= "+i.getDepId()
				         +" WHERE `Ins_Id`= "+i.getInsId();
		return tamplate.update(updateIns);
	}
	public int deleteInstructor (int insId){
		String deleteIns = "DELETE FROM `instructor` WHERE `Ins_Id`= "+insId;
		return tamplate.update(deleteIns);
	}
	public Instructors instructorById (int insId){
		String sql3 = "SELECT * FROM `instructor` WHERE `Ins_Id`= ?";
		return tamplate.queryForObject(sql3, new Object[]{insId}, new BeanPropertyRowMapper<Instructors>(Instructors.class));
	}
	public List<Instructors> viewAllInstructors (){
		String selectInstructor = "SELECT * FROM `instructor`";
		return tamplate.query(selectInstructor, new RowMapper<Instructors>() {

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
	}
	//CRUD Student Database
	public int insertStudent (Students s){
		String InsertStud = "INSERT INTO `students`(`Stud_Id`, `Stud_Name`, `Stud_Address`, `Stud_Phone`, `Dep_Id`)"
				+ " VALUES ( "+s.getStudId()+" , '"+s.getStudName()+"' , '"+s.getStudAddress()+"' , "
				+ "'"+s.getStudPhone()+"' , "+s.getDepId()+" )";
		return tamplate.update(InsertStud);
	}
	public int updateStudent (Students s){
		String updateStud = "UPDATE `students` SET `Stud_Id`= "+s.getStudId()+" ,`Stud_Name`= '"+s.getStudName()+"' ,"
				          + "`Stud_Address`= '"+s.getStudAddress()+"' ,`Stud_Phone`= '"+s.getStudPhone()+"' , "
				          + "`Dep_Id`= "+s.getDepId()+" WHERE `Stud_Id`= "+s.getStudId(); 
		return tamplate.update(updateStud);
	}
	public int deleteStudent (int studId){
		String deleteStud = "DELETE FROM `students` WHERE `Stud_Id`= "+studId;
		return tamplate.update(deleteStud);
	}
	public Students studentById (int studId){
		String sql4 = "SELECT * FROM `students` WHERE `Stud_Id`= ?";
		return tamplate.queryForObject(sql4, new Object[]{studId}, new BeanPropertyRowMapper<Students>(Students.class));
	}
	public List<Students> viewAllStudents (){
		String selectStud = "SELECT * FROM `students`";
		return tamplate.query(selectStud, new RowMapper<Students>() {

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
	}

}
