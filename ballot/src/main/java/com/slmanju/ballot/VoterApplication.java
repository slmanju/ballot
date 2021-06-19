package com.slmanju.ballot;

import com.slmanju.ballot.poll.domain.entity.Choice;
import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.domain.port.in.PollService;
import com.slmanju.ballot.voter.domain.entity.Voter;
import com.slmanju.ballot.voter.domain.port.in.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class VoterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(VoterApplication.class, args);
	}

	@Autowired
	private VoterService voterService;
	@Autowired
	private PollService pollService;

	@Override
	public void run(String... args) throws Exception {
		String sokka = voterService.save(Voter.builder().alias("Sokka").email("sokka@atla.com").build());
		String aang = voterService.save(Voter.builder().alias("Aang").email("aang@atla.com").build());
		String katara = voterService.save(Voter.builder().alias("Katara").email("katara@atla.com").build());
		String toph = voterService.save(Voter.builder().alias("Toph").email("toph@atla.com").build());
		String zuko = voterService.save(Voter.builder().alias("Zuko").email("zuko@atla.com").build());

		List<Choice> choices = Arrays.asList(
				new Choice("Sokka"),
				new Choice("Aang"),
				new Choice("Katara"),
				new Choice("Toph"),
				new Choice("Zuko"),
				new Choice("Iroh")
		);
		Poll poll = Poll.builder().owner(sokka).question("Who is your favourite ATLA character?").choices(choices).build();
		String pollId = pollService.createPoll(poll);

		System.out.println("===========================================================================");
		System.out.println("===========================================================================");

		System.out.println("Sokka " + sokka);
		System.out.println("Aang " + aang);
		System.out.println("Katara " + katara);
		System.out.println("Toph " + toph);
		System.out.println("Zuko " + zuko);
		System.out.println("Poll " + pollId);

		System.out.println("===========================================================================");
		System.out.println("===========================================================================");
	}
}
