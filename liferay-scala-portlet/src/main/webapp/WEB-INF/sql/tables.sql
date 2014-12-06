create table liferayscala_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);