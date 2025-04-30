package de.rulecorrectness.tests;


import crysl.CrySLParser;
import crysl.rule.CrySLRule;
import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.Collection;
import java.io.File;


public class RuleCorrectnessTest {

    /**
     * Counts the total number of CrySL files in a given directory path
     *
     * @param directoryPath The path to the directory containing CrySL rules
     * @return The number of .crysl files found
     */
    private int countCrySLFiles(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.err.println("Warning: Directory does not exist: " + directoryPath);
            return 0;
        }

        int count = 0;
        File[] allFiles = directory.listFiles();

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile() && file.getName().endsWith(".crysl")) {
                    count++;
                } else if (file.isDirectory()) {
                    count += countCrySLFiles(file.getAbsolutePath());
                }
            }
        }

        return count;
    }
    @Test
    public void jcaCorrectnessTest() throws IOException {
        CrySLParser parser = new CrySLParser();
        String jcaRulesPath = "path/to/JavaCryptographicArchitecture/src";
        Collection<CrySLRule> jcaRules = parser.parseRulesFromPath(jcaRulesPath);
        int ExpectedCount = countCrySLFiles(jcaRulesPath);

        // If any rule fails to parse, it will be skipped, resulting in fewer rules than expected
        if (jcaRules.size() < ExpectedCount) {
            System.err.println("Some JCA rules could not be parsed!");
            jcaRules.forEach(rule -> System.out.println("Successfully parsed: " + rule.getClassName()));
        }

        Assert.assertEquals(ExpectedCount, jcaRules.size());
    }

    @Test
    public void BouncyCastleCorrectnessTest() throws IOException {
        CrySLParser parser = new CrySLParser();
        String bouncyCastlePath = "path/to//BouncyCastle/src";
        Collection<CrySLRule> bouncyCastleRules = parser.parseRulesFromPath(bouncyCastlePath);
        int ExpectedCount = countCrySLFiles(bouncyCastlePath);

        // If any rule fails to parse, it will be skipped, resulting in fewer rules than expected
        if (bouncyCastleRules.size() < ExpectedCount) {
            System.err.println("Some Bouncy Castle rules could not be parsed!");
            bouncyCastleRules.forEach(rule -> System.out.println("Successfully parsed: " + rule.getClassName()));
        }

        Assert.assertEquals(ExpectedCount, bouncyCastleRules.size());
    }

    @Test
    public void BouncyCastleJCACorrectnessTest() throws IOException {
        CrySLParser parser = new CrySLParser();
        String bouncyCastleJCAPath = "path/to//BouncyCastle-JCA/src";
        Collection<CrySLRule> bouncyCastleJCARules = parser.parseRulesFromPath(bouncyCastleJCAPath);
        int ExpectedCount = countCrySLFiles(bouncyCastleJCAPath);

        // If any rule fails to parse, it will be skipped, resulting in fewer rules than expected
        if (bouncyCastleJCARules.size() < ExpectedCount) {
            System.err.println("Some Bouncy Castle JCA rules could not be parsed!");
            bouncyCastleJCARules.forEach(rule -> System.out.println("Successfully parsed: " + rule.getClassName()));
        }

        Assert.assertEquals(ExpectedCount, bouncyCastleJCARules.size());
    }

    @Test
    public void TinkCorrectnessTest() throws IOException {
        CrySLParser parser = new CrySLParser();
        String tinkPath = "path/to//Tink/src";
        Collection<CrySLRule> tinkRules = parser.parseRulesFromPath(tinkPath);
        int ExpectedCount = countCrySLFiles(tinkPath);

        // If any rule fails to parse, it will be skipped, resulting in fewer rules than expected
        if (tinkRules.size() < ExpectedCount) {
            System.err.println("Some Tink rules could not be parsed!");
            tinkRules.forEach(rule -> System.out.println("Successfully parsed: " + rule.getClassName()));
        }

        Assert.assertEquals(ExpectedCount, tinkRules.size());
    }

}