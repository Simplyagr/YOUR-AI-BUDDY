package com.example.newnavigation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    /*This class represents a random data in a List and maps the child item data to the respective group headers using a HashMap*/
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> que1 = new ArrayList<String>();
        que1.add("Cognitive Behavioral Therapy (CBT) has been proven time and again as the most effective therapy for anxiety and depression, but it hasn’t been available to many people.\n" +
                "Your AI Buddy makes CBT skills accessible by combining caring providers who really listen to you with 24/7 chat to support you anytime you need it.");

        List<String> que2 = new ArrayList<String>();
        que2.add("We are clinicians, engineers, designers, and caregivers. Above all, we care deeply about your health and happiness. We have dedicated our lives to making mental health care accessible for everyone, one person at a time.");

        List<String> que3 = new ArrayList<String>();
        que3.add("CBT is the most effective therapy for anxiety and depression. It helps you understand patterns in your emotions, thoughts, and behaviors that may be contributing to your anxiety and depression. Once you find those patterns, CBT helps change your thinking, take control of your emotions, and change your behavior — to feel better and reclaim your life.");

        List<String> que4 = new ArrayList<String>();
        que4.add("People often see improvements as fast as two weeks after beginning our program. Your AI Buddy extends the power of CBT to your daily life, so the more you engage with the process and practice the skills, the faster you’ll see improvements.\n" +
                "Most importantly, each person has their own timing and we respect that. You’ll set goals with our goals tab, check in regularly, and monitor your symptoms to see how you’re progressing.");

        List<String> que5 = new ArrayList<String>();
        que5.add("You can get started for free.");

        List<String> que6 = new ArrayList<String>();
        que6.add("Your AI Buddy is designed to be free and we don't give any insurances.");

        List<String> que7 = new ArrayList<String>();
        que7.add("Start with a chat with our chatbot and tell it what’s going on so we can understand your needs and provide the care you deserve.");

        List<String> que8 = new ArrayList<String>();
        que8.add("Your AI Buddy is available to people ages 18 and older who are experiencing emotional challenges or symptoms of anxiety and depression.\n" +
                "Your AI Buddy is not a good fit for people with the following conditions or circumstances:\n" +
                "Emergencies\n" +
                "Suicidal ideation\n" +
                "Substance use issues\n" +
                "Schizophrenia\n" +
                "Bipolar disorder\n" +
                "ADHD\n" +
                "Pregnant or nursing");

        List<String> que9 = new ArrayList<String>();
        que9.add("No, you don’t need a prescription to use Your AI Buddy.");

        List<String> que10 = new ArrayList<String>();
        que10.add("Yes! You can download our app and use it to take care of your mental health whenever and wherever you are.");


        List<String> que11 = new ArrayList<String>();
        que11.add("We take privacy very seriously. We don’t sell personal information under any circumstances, nor do we share or disclose personal information unless patients give their consent. We have implemented strict security measures designed to secure patients’ personal information from accidental loss and from unauthorized access, use, alteration, and disclosure, and we use encryption technology for information sent and received by us.\n");

        List<String> que12 = new ArrayList<String>();
        que12.add("No. All your information is private.");

        List<String> que13 = new ArrayList<String>();
        que13.add("We provide the AI Chatbot, Meditation, Daily goals features that make one's life balanced and improves their lifestyle. It helps them relieve their stress and be organized.");

        List<String> que14 = new ArrayList<String>();
        que14.add("Medications for anxiety and depression, often called antidepressants, work by balancing natural substances in the brain, known as neurotransmitters. ");

        List<String> que15 = new ArrayList<String>();
        que15.add("Yes. Antidepressants are a safe and highly effective means of treating anxiety, depression, and insomnia. If you and your provider decide medication is the best treatment for you, your provider will guide you in the safest and easiest way to begin your medication. \n" +
                "Antidepressants are non-controlled substances, which means that they aren’t classified as having euphoric or addictive properties. There are no examples of prolonged addictive behavior associated with these medications. However, a withdrawal effect can be experienced when stopping or reducing antidepressants so be sure to speak with your doctor before making any changes in how you take your medication.");

        List<String> que16 = new ArrayList<String>();
        que16.add("Your AI Buddy is certified by LegitScript. We work with India-based certified online pharmacies that share our same mission to make mental health care accessible for everyone.");


        expandableListDetail.put("Why should I choose Your AI Buddy?", que1);
        expandableListDetail.put("Who are you?", que2);
        expandableListDetail.put("Why Cognitive Behavioral Therapy (CBT)?", que3);
        expandableListDetail.put("How long does it take to feel better?", que4);
        expandableListDetail.put("How much does this cost?", que5);
        expandableListDetail.put("Do you take insurance?", que6);
        expandableListDetail.put("How do I get started?", que7);
        expandableListDetail.put("Who is Your AI Buddy for?", que8);
        expandableListDetail.put("Do I need a prescription to use Your AI Buddy?", que9);
        expandableListDetail.put("Is there a Your AI Buddy mobile app?", que10);
        expandableListDetail.put("How does Your AI Buddy protect my privacy?", que11);
        expandableListDetail.put("Is my information shared with other users?", que12);
        expandableListDetail.put("What medications do you offer?", que13);
        expandableListDetail.put("How do medications for anxiety and depression work?", que14);
        expandableListDetail.put("Are antidepressants safe to use?", que15);
        expandableListDetail.put("How do I know Your AI Buddy is legit?", que16);
        return expandableListDetail;
    }
}
