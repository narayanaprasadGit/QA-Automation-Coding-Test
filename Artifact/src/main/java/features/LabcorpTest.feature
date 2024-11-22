
Feature: Labcorp Career test

	@runui
  Scenario: SearchCareer and apply
    Given Launch the application url 'https://www.labcorp.com/'
    And click careers link
    And Search for 'Test Automation'
    And click on Search
    And click on First link
    Then Verify Job title as 'Functional Tester'
    Then Verify location as 'Bangalore'
    Then Verify job id as '2438895'
    Then Verify job responsibility as 'Design, develop, and execute test plans and scripts to test the functionality of AEM websites.'

