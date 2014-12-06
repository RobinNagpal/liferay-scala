package com.liferayscala.service.impl;

import com.liferayscala.service.base.EmployeeLocalServiceBaseImpl;

/**
 * The implementation of the employee local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferayscala.service.EmployeeLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferayscala.service.base.EmployeeLocalServiceBaseImpl
 * @see com.liferayscala.service.EmployeeLocalServiceUtil
 */
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
    public void syncProfileInformation() {
        try {
            Thread.sleep(2000);
            System.out.println("Synced Profile");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void syncEarnings() {
        try {
            Thread.sleep(2000);
            System.out.println("Synced Earnings");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void syncReimbursements() {
        try {
            Thread.sleep(2000);
            System.out.println("Synced Reimbursements");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
