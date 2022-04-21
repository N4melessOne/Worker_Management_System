# Worker_Management_System
Worker Management System
Worker management system

(Worker table fix)
class AWorker: 
	string name;
	string address; (kifejteni)
	Date birthDate;
	Department department; //Ahol dolgozik!
	bool leader; //a department-ben vezető-e
	string mobile;
	string email;
	int salary;
	enum sex;
	
-> class workerType extends AWorker!
	
Worker Factory

(Plant table)
class Plant :
	string name;
	string address;
	Department[] Departments; (kifejteni)
	int workers;
	double revenue;
	double cost;
	
class Department:
	List<AWorker> presentWorkers;
	string name;
	int maxWorkers;
	void addWorker(AWorker worker); //Validálni, hogy megfelelő legyen a post!
	void removeWorker(AWorker worker);
	void modifySalary(AWorker worker);
	
Singleton class Enterprise:
	string Name;
	Plant[] plants;
	double sumRevenue;
	double sumCost;
	double profit;
	
	
	
FORM:
(Login screen -> cache with users!)
