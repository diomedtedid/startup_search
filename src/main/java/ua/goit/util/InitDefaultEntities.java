package ua.goit.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import ua.goit.entity.*;
import ua.goit.entity.enums.Country;
import ua.goit.entity.enums.Industry;
import ua.goit.entity.enums.ModeOfStudy;
import ua.goit.entity.enums.Role;
import ua.goit.services.EducationService;
import ua.goit.services.ExperienceService;
import ua.goit.services.ProjectService;
import ua.goit.services.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

/**
 * Util class for creating default entities for test
 *
 * @KontarMaryna
 * @GuillaumeGingembre
 * @VitaliiProskura
 */
public class InitDefaultEntities {

    public static void initDefaultUsers(UserService usersService,
                                        ProjectService projectService, ExperienceService experienceService,
                                        EducationService educationService, PasswordEncoder passwordEncoder) {

        String youtubeLink = "https://www.youtube.com/watch?v=3wBteulZaAs&index=1&list=PL6jg6AGdCNaWF-sUH2QDudBRXo54zuN1t";

        //user
        User user1 = new User();
        user1.setUsername("Maryna");
        user1.setPassword(passwordEncoder.encode("Maryna"));
        user1.setFirstName("Maryna");
        user1.setLastName("Kontar");
        Collection<Role> roles = Arrays.asList(Role.ADMIN);
        user1.setRoles(roles);
        Contact contact = new Contact("maryna@gmail.com", "0503357740",
                "Kyiv", Country.UKRAINE);
        user1.setContact(contact);

        usersService.save(user1);


        Experience experience1 = new Experience("companyadmin1", "position1",
                "responsibility1"
                , LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));
        Experience experience2 = new Experience("companyadmin2", "position2",
                "responsibility2"
                ,LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));
        Education education1 = new Education("institution1", "stage1",
                "faculty1","fieldOfStudy", ModeOfStudy.FULL_TIME,
                LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));

        User userFromDb1 = usersService.findUserByUsername("Maryna");
        userFromDb1.setPersonalPageFotoLink("kontar.jpg");
        userFromDb1.setProfileFotoLink("yogurt.jpg");
        userFromDb1.setYoutubeLink(youtubeLink);
        userFromDb1.setAboutMe("I'm admin!");
        userFromDb1.setSkills("JavaCore, Spring, Hibernate");
        userFromDb1.addExperience(experience1);
        userFromDb1.addExperience(experience2);
        userFromDb1.addEducation(education1);

        usersService.save(userFromDb1);


        BusinessPlan businessPlan1 = new BusinessPlan("We offer the client a worthy alternative to fast food " +
                "and heavy, harmful food.",
                "At the moment, we have made a menu and prepared relations with suppliers, we are ready " +
                        "to issue a lease for the premises, but so far we are in the freezing stage, due to the lack of funds.",
                "The general market of fast food establishments is quite wide and varied, " +
                        "the cost of which exceeded billions of dollars, but we could find a loophole that " +
                        "will help us to gain a foothold in this market. The fast food market with the theme " +
                        "of healthy eating is only beginning, an example of which is salathy, but the industry " +
                        "itself is still emerging.");
        Project project1 = new Project("Network of yogurt bars", BigDecimal.valueOf(100000),BigDecimal.valueOf(10000),
                Industry.SERVICES, new Address("Kiev", null, Country.UKRAINE),
                "We offer a product that the client has not yet seen in the world of restaurant business in Kiev.\n" +
                        "We provide an opportunity for the client to form the composition of his yogurt himself, thanks to which, we are flexible towards the client.\n" +
                        "We offer the client a worthy alternative to fast food and heavy, harmful food.",
                LocalDate.of(2017, 9, 1));

        project1.setBusinessPlan(businessPlan1);
        userFromDb1.addProject(project1);
        projectService.save(project1);



//user2
        User user2 = new User();
        user2.setUsername("Guillaume");
        user2.setFirstName("Guillaume");
        user2.setLastName("Gingembre");
        user2.setPassword(passwordEncoder.encode("Guillaume"));
        Collection<Role> roles1 = Arrays.asList(Role.USER);
        user2.setRoles(roles1);
        Contact contact1 = new Contact("guilaume@gmail.com", "+380971713778", "Paris", Country.FRANCE);
        user2.setContact(contact1);

        usersService.save(user2);


        Experience experience3 = new Experience("companyadmin3", "position3",
                "responsibility3"
                ,LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));
        Experience experience4 = new Experience("companyadmin4", "position4",
                "responsibility4"
                ,LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));

        Education education2 = new Education("institution2", "stage2",
                "faculty2","fieldOfStudy2", ModeOfStudy.EVENING
                ,LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));

        User userFromDb2 = usersService.findUserByUsername("Guillaume");
        userFromDb2.setPersonalPageFotoLink("guillaume.jpg");
        userFromDb2.setProfileFotoLink("donates.jpg");
        userFromDb2.addExperience(experience3);
        userFromDb2.addExperience(experience4);
        userFromDb2.addEducation(education2);
        userFromDb2.setYoutubeLink(youtubeLink);

        usersService.save(userFromDb2);

        BusinessPlan businessPlan2 = new BusinessPlan("Ready to produce the most delicious donates in the world!",
                "At the moment, we have made a menu and prepared relations with suppliers, we are ready " +
                        "to issue a lease for the premises, but so far we are in the freezing stage, due to the lack of funds.",
                "market");
        Project project2 = new Project("Donates", BigDecimal.valueOf(100000), BigDecimal.valueOf(20000),
                Industry.SERVICES, new Address("Kiev", null, Country.UKRAINE),
                "Ready to produce the most delicious donates in the world!", LocalDate.of(2017, 8, 1));

        project2.setBusinessPlan(businessPlan2);
        userFromDb2.addProject(project2);
        projectService.save(project2);





//user3
        User user3 = new User();
        user3.setUsername("Vitalii");
        user3.setFirstName("Vitalii");
        user3.setLastName("Proskura");
        user3.setPassword(passwordEncoder.encode("Vitalii"));
        Collection<Role> roles2 = Arrays.asList(Role.USER);
        user3.setRoles(roles2);
        Contact contact2 = new Contact("vilalii@gmail.com", "+380965067381", "London", Country.UNITED_KINGDOM);
        user3.setContact(contact2);

        usersService.save(user3);


        Experience experience5 = new Experience("companyadmin5", "position5",
                "responsibility5"
                ,LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));
        Experience experience6 = new Experience("companyadmin6", "position6",
                "responsibility6"
                ,LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));
        Education education3 = new Education("institution3", "stage3",
                "faculty3","fieldOfStudy3", ModeOfStudy.REMOTE
                ,LocalDate.of(2002, 9, 1),
                LocalDate.of(2007, 6, 30));

        User userFromDb3 = usersService.findUserByUsername("Vitalii");
        userFromDb3.setPersonalPageFotoLink("proskura.jpg");
        userFromDb3.setProfileFotoLink("scooters.jpg");
        userFromDb3.addExperience(experience5);
        userFromDb3.addExperience(experience6);
        userFromDb3.addEducation(education3);
        userFromDb3.setYoutubeLink(youtubeLink);

        usersService.save(userFromDb3);


        BusinessPlan businessPlan4 = new BusinessPlan("idea4", "currentState4","market4");
        Project project4 = new Project("Scooter rental", BigDecimal.valueOf(100000),BigDecimal.valueOf(20000),
                Industry.SERVICES, new Address("Kiev", null, Country.UKRAINE),
                "Scooter rental and maintenance", LocalDate.of(2017, 8, 1));

        project4.setBusinessPlan(businessPlan4);
        userFromDb3.addProject(project4);
        projectService.save(project4);
    }


}
