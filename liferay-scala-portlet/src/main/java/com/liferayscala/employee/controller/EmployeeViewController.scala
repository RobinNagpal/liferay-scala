package com.liferayscala.employee.controller

import com.liferayscala.service.EmployeeLocalServiceUtil
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.context.request.async.DeferredResult
import org.springframework.web.portlet.bind.annotation.RenderMapping
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent._

/**
 * Created by rnagpal on 11/30/2014.
 */
@Controller
@RequestMapping(Array("VIEW"))
class EmployeeViewController {


  val EMPLOYEE_VIEW_TEMPLATE = "employee/view"

  @RenderMapping
  def showEmployeeInformation:String = {
    val viewName: Future[String] = getViewName

    val templateName: String = Await.result(viewName, 5 seconds)
    return templateName
  }

  def getViewName: Future[String] =  {


    val profileSyncFuture = Future {  EmployeeLocalServiceUtil.syncProfileInformation()      }
    val earningsSyncFuture = Future {  EmployeeLocalServiceUtil.syncEarnings()      }
    val reimbursementSyncFuture = Future {  EmployeeLocalServiceUtil.syncReimbursements()      }

    val viewName: Future[String] = for {
      profileSync <- profileSyncFuture
      earningsSync <- earningsSyncFuture
      reimbursementSync <- reimbursementSyncFuture
    } yield {
        "employee/view"
    }

    return viewName
  }

}
