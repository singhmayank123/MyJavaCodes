class DNS:
    def __init__(self):
        self.__db = {} # private attribute to store the domain name and IPA

    def update(self, domain_name, IPA):
        """Updates the DNS with a new domain name and its IPA."""
        self.__db[domain_name] = IPA

    def lookup(self, domain_name):
        """Returns the IPA for a domain name, or None if it does not exist."""
        return self.__db.get(domain_name)

dns = DNS()
while True:
    user_input = input("Enter command (u, l, q): ")
    if user_input == "u":
        domain_name = input("Enter the domain name: ")
        IPA = input("Enter the IPA: ")
        dns.update(domain_name, IPA)
        print("DNS updated.")
    elif user_input == "l":
        domain_name = input("Enter the domain name: ")
        IPA = dns.lookup(domain_name)
        if IPA is None:
            print("No IPA found for that domain name.")
        else:
            print(IPA)
    elif user_input == "q":
        break
    else:
        print("Bad command.")

