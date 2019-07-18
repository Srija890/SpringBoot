package com.stackroute.keepnote.controller;


/*Annotate the class with @Controller annotation. @Controller annotation is used to mark
 * any POJO class as a controller so that Spring can recognize this class as a Controller
 * */

import com.stackroute.keepnote.model.Note;
import com.stackroute.keepnote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class NoteController {
	/*
	 * From the problem statement, we can understand that the application
	 * requires us to implement the following functionalities.
	 *
	 * 1. display the list of existing notes from the collection. Each note
	 *    should contain Note Id, title, content, status and created date.
	 * 2. Add a new note which should contain the note id, title, content and status.
	 * 3. Delete an existing note.
	 * 4. Update an existing note.
	 */



	/*
	 * Get the application context from resources/beans.xml file using ClassPathXmlApplicationContext() class.
	 * Retrieve the Note object from the context.
	 * Retrieve the NoteRepository object from the context.
	 */

	/*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
	*//*Note note = applicationContext.getBean("note", Note.class);
	NoteRepository noterobj = applicationContext.getBean("noteRepository", NoteRepository.class);
*/
@Autowired
Note notedetails;
@Autowired
NoteRepository noteRepository;

	/*Define a handler method to read the existing notes by calling the getAllNotes() method
	 * of the NoteRepository class and add it to the ModelMap which is an implementation of Map
	 * for use when building model data for use with views. it should map to the default URL i.e. "/" */


	@RequestMapping("/")
	public ModelAndView getAllNotes() {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute(noteRepository.getAllNotes());
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("index");
		modelview.addAllObjects(modelMap);
		return modelview;
	}


	/*Define a handler method which will read the Note data from request parameters and
	 * save the note by calling the addNote() method of NoteRepository class. Please note
	 * that the createdAt field should always be auto populated with system time and should not be accepted
	 * from the user. Also, after saving the note, it should show the same along with existing
	 * notes. Hence, reading notes has to be done here again and the retrieved notes object
	 * should be sent back to the view using ModelMap.
	 * This handler method should map to the URL "/saveNote".
	 */

	/*@RequestMapping(value = "/saveNote", method = RequestMethod.POST)
	public String addNote(ModelMap model,int noteId, String noteTitle, String noteContent, String noteStatus) {
		Note notedetails = new Note();			notedetails.setNoteId(noteId);
		notedetails.setNoteTitle(noteTitle);
		notedetails.setNoteContent(noteContent);
		notedetails.setNoteStatus(noteStatus);
		notedetails.setCreatedAt(LocalDateTime.now());
		noterobj.addNote(notedetails);

		*//*ModelMap modelmap = new ModelMap();
		modelmap.addAllAttributes(noterobj.getList());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addAllObjects(modelmap);*//*
		model.addAttribute("notes",noterobj.getAllNotes());
		return "index";
	}
*/
	@RequestMapping(value="/saveNote",method = RequestMethod.POST)
	public String addNote(int noteId, String noteTitle, String noteContent, String noteStatus,ModelMap model)
	{
		//Note notedetails=new Note();
		notedetails.setNoteId(noteId);
		notedetails.setNoteTitle(noteTitle);
		notedetails.setNoteContent(noteContent);
		notedetails.setNoteStatus(noteStatus);
		notedetails.setCreatedAt(LocalDateTime.now());
		noteRepository.addNote(notedetails);
		model.addAttribute("notes",noteRepository.getAllNotes());
		return "index";
	}




	/* Define a handler method to delete an existing note by calling the deleteNote() method
	 * of the NoteRepository class
	 * This handler method should map to the URL "/deleteNote"
	 */

	@RequestMapping(value = "/deleteNote")
	public String deleteNote(@RequestParam("noteId") int noteId) {
		noteRepository.deleteNote(noteId);
		return "redirect:/";
	}
}