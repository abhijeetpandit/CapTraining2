import com.abhi.beans.Address;
import com.abhi.beans.Customer;
import com.abhi.exception.BankServiceException;
import com.abhi.exception.InvalidAccountNumberException;
import com.abhi.service.BankService;
import com.abhi.service.BankServiceImpl;


public class Test {
	public static void main(String[] args) {
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
		
		testCreateAccountWithLessBalance(customer4, bankService);
		
		testCreate5Accounts(customer1, customer2, customer3, customer4,
				customer5, bankService);
		
		//deposit invalid account no
		testDeposit(bankService, 11, 500);
		System.out.println(((BankServiceImpl) bankService).getAccountRepository());
		
		//Withdraw with invalid account no
		testWithdraw(bankService, 15, 5000);
		System.out.println(((BankServiceImpl) bankService).getAccountRepository());
	
		//Deposit success
		testDeposit(bankService, 1001, 2222);
		System.out.println(((BankServiceImpl) bankService).getAccountRepository());
		
		//Withdrawal fail due to insufficient balance
		testWithdraw(bankService, 1002, 3001);
		System.out.println(((BankServiceImpl) bankService).getAccountRepository());
		
		//Fund transfer insufficient balance
		testTransfer(bankService, 1000, 1001, 5555);
		System.out.println(((BankServiceImpl) bankService).getAccountRepository());
		
		//Fund transfer successful
		testTransfer(bankService, 1000, 1001, 2000);
		System.out.println(((BankServiceImpl) bankService).getAccountRepository());
		
		//Print transactions of all
		try {
			System.out.println(bankService.printTransactions(1000));
			System.out.println(bankService.printTransactions(1001));
			System.out.println(bankService.printTransactions(1002));
			System.out.println(bankService.printTransactions(1003));
			System.out.println(bankService.printTransactions(1004));
			System.out.println(bankService.printTransactions(999));
		} catch (InvalidAccountNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void testCreateAccountWithLessBalance(Customer customer4,
			BankService bankService) {
		//Try creating account with less balance
		try {
			bankService.createAccount(customer4, 500);
		} catch (BankServiceException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void testCreate5Accounts(Customer customer1,
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
	
	
	
	
	
	
	
	
	
	
	
	private static Address createAddress(String string, String string2,
			String string3) {
		Address address = new Address();
		address.setAddressLine(string);
		address.setCity(string2);
		address.setCountry(string3);
		return address;
	}
	
	private static Customer createCustomer(String firstName, String lastName, Address address) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		return customer;
	}
}
