import com.abhi.beans.Address;
import com.abhi.beans.Customer;
import com.abhi.exception.BankServiceException;
import com.abhi.exception.InsufficientBalanceException;
import com.abhi.exception.InvalidAccountNumberException;
import com.abhi.service.BankService;
import com.abhi.service.BankServiceImpl;


public class TestWithThreads {
	public static void main(String[] args) {
		TestWithThreads testWithThreads = new TestWithThreads();
		testWithThreads.test();
		
	}

	private void test() {
		//Account1
		Address address1 = createAddress("Shivaji nagar", "Pune", "India");
		Address address2 = createAddress("Dhanori", "Pune", "India");
		Address address3 = createAddress("Gokul nagar", "Pune", "India");
		Address address4 = createAddress("Koregaon park", "Pune", "India");
		Address address5 = createAddress("Talawade", "Pune", "India");
		
		Customer customer1 = createCustomer("Abhijeet", "pandit", address1);
		Customer customer2 = createCustomer("Abhijeet", "pandit", address2);
		Customer customer3 = createCustomer("Abhijeet", "pandit", address3);
		Customer customer4 = createCustomer("Abhijeet", "pandit", address4);
		Customer customer5 = createCustomer("Abhijeet", "pandit", address5);
		
		BankService bankService = new BankServiceImpl();
		
		testCreate5Accounts(customer1, customer2, customer3, customer4,
				customer5, bankService);
		
		Thread threadOne = new Thread(new MyWithdrawer(bankService, 1000, 4000), "Thread one");
		Thread threadTwo = new Thread(new MyWithdrawer(bankService, 1000, 4000), "Thread two");
		threadOne.start();
		threadTwo.start();
		try {
			threadOne.join();
			threadTwo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(((BankServiceImpl)bankService).getAccountRepository());
	}

	public class MyWithdrawer implements Runnable {
		private BankService bankService;
		private int accountNo;
		private double amount;

		public MyWithdrawer(BankService bankService, int accountNo, double amount) {
			this.bankService = bankService;
			this.accountNo = accountNo;
			this.amount = amount;
		}

		@Override
		public void run() {
			try {
				System.out.println("Thread running =" + Thread.currentThread().getName());
				double result = bankService.withdraw(accountNo, amount);
				System.out.println("Balance after withdrawal = " + result);
			} catch (InvalidAccountNumberException e) {
				System.out.println(e.getMessage());
			} catch (InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

	private void testCreate5Accounts(Customer customer1,
			Customer customer2, Customer customer3, Customer customer4,
			Customer customer5, BankService bankService) {
		//Create all 5 accounts
		try {
			System.out.println(bankService.createAccount(customer1, 5000));
			System.out.println(bankService.createAccount(customer2, 10000));
			System.out.println(bankService.createAccount(customer3, 3000));
			System.out.println(bankService.createAccount(customer4, 40000));
			System.out.println(bankService.createAccount(customer5, 50000));
		} catch (BankServiceException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(((BankServiceImpl) bankService).getAccountRepository());
	}
	
	
	private static void testDeposit(BankService bankService, int accountNo, double amount) {
		//Test invalid account no deposit
		try {
			double amountDeposit = bankService.deposit(accountNo, amount);
			System.out.println("Balance after Deposit= " + amountDeposit);
		} catch (BankServiceException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void testWithdraw(BankService bankService, int accountNo, double amount) {
		//Test invalid account no withdraw
		try {
			double amountWithdraw = bankService.withdraw(accountNo, amount);
			System.out.println("Balance after withdraw" + amountWithdraw);
		} catch (BankServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	
	private static void testTransfer(BankService bankService, int sourceAccountNo, int destinationAccountNo,
			double amount) {
		try {
			String reply = bankService.transferAmount(sourceAccountNo, destinationAccountNo, amount);
			System.out.println(reply);
		} catch (BankServiceException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	private Address createAddress(String string, String string2,
			String string3) {
		Address address = new Address();
		address.setAddressLine(string);
		address.setCity(string2);
		address.setCountry(string3);
		return address;
	}
	
	private Customer createCustomer(String firstName, String lastName, Address address) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		return customer;
	}
}
