package com.myfaculty.myapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@Autowired
	public DatabaseInfo di;

	// Home
	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("home", "command", new Object());
	}
	// Departments Requests
	@RequestMapping("/addDepartment")
	public ModelAndView addDepartment(Department d) {
		return new ModelAndView("addDepartment", "command", d);
	}

	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public ModelAndView saveDepartment(@ModelAttribute("d") Department d) {
		di.insertDepartment(d);
		return new ModelAndView("redirect:/viewDepartment");
	}

	@RequestMapping(value = "/viewDepartment")
	public ModelAndView viewDepartment() {
		List<Department> list1 = di.viewAllDepartments();
		return new ModelAndView("viewDepartment", "list1", list1);
	}

	@RequestMapping(value = "/deleteDepartment/{depId}", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(@PathVariable int depId) {
		di.deleteDepartment(depId);
		return new ModelAndView("redirect:/viewDepartment");
	}

	// Courses Requests
	@RequestMapping("/addCourses")
	public ModelAndView addCourses(Courses c) {
		return new ModelAndView("addCourses", "command", c);
	}

	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public ModelAndView saveCourses(@ModelAttribute("c") Courses c) {
		di.insertCourses(c);
		return new ModelAndView("redirect:/viewCourses");
	}

	@RequestMapping("/viewCourses")
	public ModelAndView viewCourses() {
		List<Courses> list2 = di.viewAllCourses();
		return new ModelAndView("viewCourses", "list2", list2);
	}

	@RequestMapping(value = "/deleteCourses/{coId}", method = RequestMethod.GET)
	public ModelAndView deleteCourses(@PathVariable int coId) {
		di.deleteCourses(coId);
		return new ModelAndView("redirect:/viewCourses");
	}

	// Instructors Requests
	@RequestMapping("/addInstructors")
	public ModelAndView addInstructors(Instructors i) {
		return new ModelAndView("addInstructors", "command", i);
	}

	@RequestMapping(value = "/save3", method = RequestMethod.POST)
	public ModelAndView saveInstructors(@ModelAttribute("i") Instructors i) {
		di.insertInstructor(i);
		return new ModelAndView("redirect:/viewInstructors");
	}

	@RequestMapping("/viewInstructors")
	public ModelAndView viewInstructors() {
		List<Instructors> list3 = di.viewAllInstructors();
		return new ModelAndView("viewInstructors", "list3", list3);
	}

	@RequestMapping(value = "deleteInstructor/{insId}", method = RequestMethod.GET)
	public ModelAndView deleteInstructors(@PathVariable int insId) {
		di.deleteInstructor(insId);
		return new ModelAndView("redirect:/viewInstructors");
	}

	// Students Requests
	@RequestMapping("/addStudents")
	public ModelAndView addStudents(Students s) {
		return new ModelAndView("addStudents", "command", s);
	}

	@RequestMapping(value = "/save4", method = RequestMethod.POST)
	public ModelAndView saveStudents(@ModelAttribute("s") Students s) {
		di.insertStudent(s);
		return new ModelAndView("redirect:/viewStudents");
	}

	@RequestMapping("/viewStudents")
	public ModelAndView viewStudents() {
		List<Students> list4 = di.viewAllStudents();
		return new ModelAndView("viewStudents", "list4", list4);
	}

	@RequestMapping(value = "/deleteStudents/{studId}", method = RequestMethod.GET)
	public ModelAndView deleteStudents(@PathVariable int studId) {
		di.deleteStudent(studId);
		return new ModelAndView("redirect:/viewStudents");
	}
	
	//Log in
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}