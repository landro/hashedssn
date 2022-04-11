# SSN (Personnummer)

## How to get SSN hashes

Make sure you have java and maven installed

```bash
git clone https://github.com/landro/hashedssn
```

Go into the `hashedssn` folder and run

```bash
    mvn exec:java -Dexec.mainClass=HashedSSN
```

This will generate a file filled with `SSN -> Base64(sha512(SSN))` of all the possible SSN's in Norway.

To get the clear text SSN from a hashed SSN you can use this command:

```bash
cat rainbow.txt | grep {HASHED_SSN}
```