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
            throw new RuntimeException("Directory does not exist: " + directoryPath);
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
        String jcaRulesPath = "./../JavaCryptographicArchitecture/src";
        Collection<CrySLRule> jcaRules = parser.parseRulesFromPath(jcaRulesPath);
        int ExpectedCount = countCrySLFiles(jcaRulesPath);

        Assert.assertEquals(ExpectedCount, jcaRules.size());
    }

    @Test
    public void BouncyCastleCorrectnessTest() throws IOException {
        CrySLParser parser = new CrySLParser();
        String bouncyCastlePath = "./../BouncyCastle/src";
        Collection<CrySLRule> bouncyCastleRules = parser.parseRulesFromPath(bouncyCastlePath);
        int ExpectedCount = countCrySLFiles(bouncyCastlePath);

        Assert.assertEquals(ExpectedCount, bouncyCastleRules.size());
    }

    @Test
    public void BouncyCastleJCACorrectnessTest() throws IOException {
        CrySLParser parser = new CrySLParser();
        String bouncyCastleJCAPath = "./../BouncyCastle-JCA/src";
        Collection<CrySLRule> bouncyCastleJCARules = parser.parseRulesFromPath(bouncyCastleJCAPath);
        int ExpectedCount = countCrySLFiles(bouncyCastleJCAPath);

        Assert.assertEquals(ExpectedCount, bouncyCastleJCARules.size());
    }

    @Test
    public void TinkCorrectnessTest() throws IOException {
        CrySLParser parser = new CrySLParser();
        String tinkPath = "./../Tink/src";
        Collection<CrySLRule> tinkRules = parser.parseRulesFromPath(tinkPath);
        int ExpectedCount = countCrySLFiles(tinkPath);

        Assert.assertEquals(ExpectedCount, tinkRules.size());
    }

}