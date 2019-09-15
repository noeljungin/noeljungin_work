package board.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ModelAndView defaultExceptionhandler(HttpServletRequest request, Exception exception) {
		ModelAndView mv = new ModelAndView("/error/error_default");
		mv.addObject("exception", exception);
		log.error("exception", exception);
		return mv;
	}
}
