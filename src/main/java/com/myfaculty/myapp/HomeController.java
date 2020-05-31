package com.myfaculty.myapp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	private static final String MODEL_NAME = "command";

	@Autowired
	public DatabaseInfo di;

	// Home
	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("home", MODEL_NAME, new Object());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	// Departments Requests
	@GetMapping("/addDepartment")
	public ModelAndView addDepartment(Department d) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("addDepartment", MODEL_NAME, d);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@PostMapping("/save1")
	public ModelAndView saveDepartment(@ModelAttribute("d") Department d) {
		ModelAndView modelAndView = null;
		try {
			di.insertDepartment(d);
			modelAndView = new ModelAndView("redirect:/viewDepartment");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@GetMapping("/viewDepartment")
	public ModelAndView viewDepartment() {
		ModelAndView modelAndView = null;
		List<Department> departmentList = null;
		try {
			departmentList = di.viewAllDepartments();
			modelAndView = new ModelAndView("viewDepartment", "list1", departmentList);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@GetMapping("/deleteDepartment/{depId}")
	public ModelAndView deleteDepartment(@PathVariable int depId) {
		ModelAndView modelAndView = null;
		try {
			di.deleteDepartment(depId);
			modelAndView = new ModelAndView("redirect:/viewDepartment");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	// Courses Requests
	@GetMapping("/addCourses")
	public ModelAndView addCourses(Courses c) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("addCourses", MODEL_NAME, c);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@PostMapping(value = "/save2")
	public ModelAndView saveCourses(@ModelAttribute("c") Courses c) {
		ModelAndView modelAndView = null;
		try {
			di.insertCourses(c);
			modelAndView = new ModelAndView("redirect:/viewCourses");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@GetMapping("/viewCourses")
	public ModelAndView viewCourses() {
		ModelAndView modelAndView = null;
		List<Courses> coursesList = null;
		try {
			coursesList = di.viewAllCourses();
			modelAndView = new ModelAndView("viewCourses", "list2", coursesList);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@GetMapping("/deleteCourses/{coId}")
	public ModelAndView deleteCourses(@PathVariable int coId) {
		ModelAndView modelAndView = null;
		try {
			di.deleteCourses(coId);
			modelAndView = new ModelAndView("redirect:/viewCourses");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	// Instructors Requests
	@GetMapping("/addInstructors")
	public ModelAndView addInstructors(Instructors i) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("addInstructors", MODEL_NAME, i);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@PostMapping("/save3")
	public ModelAndView saveInstructors(@ModelAttribute("i") Instructors i) {
		ModelAndView modelAndView = null;
		try {
			di.insertInstructor(i);
			modelAndView = new ModelAndView("redirect:/viewInstructors");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@GetMapping("/viewInstructors")
	public ModelAndView viewInstructors() {
		ModelAndView modelAndView = null;
		List<Instructors> instructorsList = null;
		try {
			instructorsList = di.viewAllInstructors();
			modelAndView = new ModelAndView("viewInstructors", "list3", instructorsList);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@GetMapping("deleteInstructor/{insId}")
	public ModelAndView deleteInstructors(@PathVariable int insId) {
		ModelAndView modelAndView = null;
		try {
			di.deleteInstructor(insId);
			modelAndView = new ModelAndView("redirect:/viewInstructors");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	// Students Requests
	@GetMapping("/addStudents")
	public ModelAndView addStudents(Students s) {
		ModelAndView modelAndView = null;
		try {
			modelAndView = new ModelAndView("addStudents", MODEL_NAME, s);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@PostMapping("/save4")
	public ModelAndView saveStudents(@ModelAttribute("s") Students s) {
		ModelAndView modelAndView = null;
		try {
			di.insertStudent(s);
			modelAndView = new ModelAndView("redirect:/viewStudents");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@GetMapping("/viewStudents")
	public ModelAndView viewStudents() {
		ModelAndView modelAndView = null;
		List<Students> studentsList = null;
		try {
			studentsList = di.viewAllStudents();
			modelAndView = new ModelAndView("viewStudents", "list4", studentsList);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}

	@GetMapping("/deleteStudents/{studId}")
	public ModelAndView deleteStudents(@PathVariable int studId) {
		ModelAndView modelAndView = null;
		try {
			di.deleteStudent(studId);
			modelAndView = new ModelAndView("redirect:/viewStudents");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return modelAndView;
	}
}
	//Log in