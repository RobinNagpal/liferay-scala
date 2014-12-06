package com.liferayscala.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferayscala.service.ClpSerializer;
import com.liferayscala.service.EmployeeLocalServiceUtil;
import com.liferayscala.service.EmployeeServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            EmployeeLocalServiceUtil.clearService();

            EmployeeServiceUtil.clearService();
        }
    }
}
