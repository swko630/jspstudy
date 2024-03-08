package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;

public class MyInterfaceImpl implements MyInterface {

  @Override
  public ActionForward getDate(HttpServletRequest request) {
    // String 은 보여줄 view의 이름을 반환한다. getDate는 request에 저장하고 forward 하여 request를 전달한다. 
    request.setAttribute("date", DateTimeFormatter.ofPattern("yyyy. MM. dd.").format(LocalDate.now()));
    return new ActionForward("/view/date.jsp", false);
  }

  @Override
  public ActionForward getTime(HttpServletRequest request) {
    request.setAttribute("time", DateTimeFormatter.ofPattern("HH : mm : ss.SSS").format(LocalTime.now()));
    return new ActionForward("/view/time.jsp", false);
  }

  @Override
  public ActionForward getDateTime(HttpServletRequest request) {
    request.setAttribute("datetime", DateTimeFormatter.ofPattern("yyyy. MM. dd. HH : mm : ss.SSS").format(LocalDateTime.now()));
    return new ActionForward("/view/datetime.jsp", false);
  }

}
