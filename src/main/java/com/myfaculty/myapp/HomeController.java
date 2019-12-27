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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		try {
			return new ModelAndView("home", "command", new Object());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	// Departments Requests
	@RequestMapping(value = "/addDepartment", method = RequestMethod.GET)
	public ModelAndView addDepartment(Department d) {
		try {
			return new ModelAndView("addDepartment", "command", d);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public ModelAndView saveDepartment(@ModelAttribute("d") Department d) {
		try {
			di.insertDepartment(d);
			return new ModelAndView("redirect:/viewDepartment");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/viewDepartment", method = RequestMethod.GET)
	public ModelAndView viewDepartment() {
		try {
			List<Department> list1 = di.viewAllDepartments();
			return new ModelAndView("viewDepartment", "list1", list1);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/deleteDepartment/{depId}", method = RequestMethod.GET)
	public ModelAndView deleteDepartment(@PathVariable int depId) {
		try {
			di.deleteDepartment(depId);
			return new ModelAndView("redirect:/viewDepartment");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	// Courses Requests
	@RequestMapping(value = "/addCourses", method = RequestMethod.GET)
	public ModelAndView addCourses(Courses c) {
		try {
			return new ModelAndView("addCourses", "command", c);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public ModelAndView saveCourses(@ModelAttribute("c") Courses c) {
		try {
			di.insertCourses(c);
			return new ModelAndView("redirect:/viewCourses");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/viewCourses", method = RequestMethod.GET)
	public ModelAndView viewCourses() {
		try {
			List<Courses> list2 = di.viewAllCourses();
			return new ModelAndView("viewCourses", "list2", list2);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/deleteCourses/{coId}", method = RequestMethod.GET)
	public ModelAndView deleteCourses(@PathVariable int coId) {
		try {
			di.deleteCourses(coId);
			return new ModelAndView("redirect:/viewCourses");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	// Instructors Requests
	@RequestMapping(value = "/addInstructors", method = RequestMethod.GET)
	public ModelAndView addInstructors(Instructors i) {
		try {
			return new ModelAndView("addInstructors", "command", i);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/save3", method = RequestMethod.POST)
	public ModelAndView saveInstructors(@ModelAttribute("i") Instructors i) {
		try {
			di.insertInstructor(i);
			return new ModelAndView("redirect:/viewInstructors");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/viewInstructors", method = RequestMethod.GET)
	public ModelAndView viewInstructors() {
		try {
			List<Instructors> list3 = di.viewAllInstructors();
			return new ModelAndView("viewInstructors", "list3", list3);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "deleteInstructor/{insId}", method = RequestMethod.GET)
	public ModelAndView deleteInstructors(@PathVariable int insId) {
		try {
			di.deleteInstructor(insId);
			return new ModelAndView("redirect:/viewInstructors");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	// Students Requests
	@RequestMapping(value = "/addStudents", method = RequestMethod.GET)
	public ModelAndView addStudents(Students s) {
		try {
			return new ModelAndView("addStudents", "command", s);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/save4", method = RequestMethod.POST)
	public ModelAndView saveStudents(@ModelAttribute("s") Students s) {
		try {
			di.insertStudent(s);
			return new ModelAndView("redirect:/viewStudents");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/viewStudents", method = RequestMethod.GET)
	public ModelAndView viewStudents() {
		try {
			List<Students> list4 = di.viewAllStudents();
			return new ModelAndView("viewStudents", "list4", list4);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}

	@RequestMapping(value = "/deleteStudents/{studId}", method = RequestMethod.GET)
	public ModelAndView deleteStudents(@PathVariable int studId) {
		try {
			di.deleteStudent(studId);
			return new ModelAndView("redirect:/viewStudents");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new ModelAndView();
	}
}
	//Log in