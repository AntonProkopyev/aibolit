// SPDX-FileCopyrightText: Copyright (c) 2024-2025 Yegor Bugayenko
// SPDX-License-Identifier: MIT

class Foo {
	public void storePerson(Person input) {
	  try{
		validatePerson(); // if person is not valid, don't go through the flow
		try{
		  writeInLog("I will be storing this person: " + input.getName());
		}
		catch(IOException e){
		  System.out.println("Should have generated a logFile first, but hell, this won't put the flow in jeopardy.");
		  throw e;
		}
		performPersistenceTasks(input);

	  }
	  catch(Exception ex){
		ex.printStackTrace();
		throw ex;
	  }
    }
}
