dns = DNS()
while True:
    print("Enter 'update' to add a new domain name and IPA, or 'lookup' to find the IPA for a domain name.")
    user_input = input()
    if user_input == "update":
        domain_name = input("Enter the domain name: ")
        IPA = input("Enter the IPA: ")
        dns.update(domain_name, IPA)
        print("DNS updated.")
    elif user_input == "lookup":
        domain_name = input("Enter the domain name: ")
        IPA = dns.lookup(domain_name)
        if IPA is None:
            print("No IPA found for that domain name.")
        else:
            print("IPA for {} is {}.".format(domain_name, IPA))
    else:
        print("Invalid input.")
