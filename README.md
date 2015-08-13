# vaco

Universal library to handle server-side validations and using conditions.

There are some implemented validators such as IBAN, SWIFT/BIC, VATIN, National Identification Number or E-mail address. Also, creating custom validation routines should be simple.

## Motivation

There are two types of developers. One of them is capable to create a huge spaghetti monster to serve a hundred-line code method. The others are looking for optimalizations and create more or less clean code. Creation of this library was motivated with the need of the clean and reusable code. 

## Implementation

Let's say that you have a controller with a method to validate currently leaving screen. There is a bunch of user's inputs validations. You need to validate primitive and complex types. You need to validate dependencies. You need to validate all of it using some rules.

How to validate it in the most easy and simple way? Should I write a spaghetti monster? Or should I create a bunch of methods in my controller? Or how about a helper class with many static methods in it?

Or how about using a simple and clean code? Let's say that you are creating an application for FBI to register wanted criminals. There is a screen, where user needs to put a name, description, origin, known associates and hideouts. Now, you need to validate all those inputs. E.g. the associate in the list should be unique in this context, there shouldn't be any duplicates. There could be a validation of the SSN or even ITIN. You could need to validate all addresses of known hideouts but only if the address belongs to Brooklyn and that criminal record describes someone who lives in Brooklyn. Those could be the rules for filling that form, declared in the analysis.
The resulting code could look like this.

```java

	public boolean validate(Criminal criminal) {
		
		SsnAdapter ssn = new SsnAdapter(criminal.getSsn());
		ItinAdapter itin = new ItinAdapter(criminal.getItin());
		UniqueAssociativesAdapter isUniqueAssociates = new UniqueAssociativesAdapter(criminal.getAssociatives());
		HideoutsAdapter hideouts = new HideoutsAdapter(criminal.getHideouts());
		Condition addressesInBrooklyn = new ChainableCondition(criminal.getHideouts());
		Condition livesInBrooklyn = new ChainableCondition(criminal.getAddress());
		 
		StandardValidator validator = new StandardValidator();
		validator.register(ssn).register(itin).register(isUniqueAssociates).register(hideouts.validateOn(addressesInBrooklyn).and(livesInBrooklyn));
		if (!validator.validate) {
			raiseErrorMessage(validator.getFirstFailedMessage());
		}

	}

```

And that's it. It's as simple as that. Every validation adapter is fully testable. Your validation method itself has only a few lines of code.

Enjoy.