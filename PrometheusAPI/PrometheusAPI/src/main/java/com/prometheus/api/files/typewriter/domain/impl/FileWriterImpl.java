package com.prometheus.api.files.typewriter.domain.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.prometheus.api.files.typewriter.adapters.input.FileWriterInputAdapters;
import com.prometheus.api.files.typewriter.adapters.output.FileWriterOutputAdapters;
import com.prometheus.api.files.typewriter.domain.dto.VueComponentsLibrary;

public class FileWriterImpl implements FileWriterInputAdapters, FileWriterOutputAdapters {

	protected static final Path PROJECT_PATH;
	protected static final Path OPT_PATH;

	static {
		try {
			PROJECT_PATH = Paths.get(System.getProperty("user.dir").toString());
			OPT_PATH = PROJECT_PATH.resolve("opt");
		} catch (Exception e) {
			throw new RuntimeException("[ERROR] - Erro ao adquirir o caminho do projeto");
		}
	}

	public static void createArchive(Path path, String fileName) {
		Path fullPath = path.resolve(fileName);
		createArchive(fullPath);
	}
	
	public static void createArchive(Path path) {
		try {
			Files.createFile(path);
		} catch (IOException e) {
			System.err.println("[ERROR] - Ocorreu um erro ao criar o arquivo: " + e.getMessage());
		}
		
		
	}
	
	public static void appendInArchive(Path path, String fileName, String content) {
		Path fullPath = path.resolve(fileName);
		appendInArchive(fullPath, content);
	}
	
	private static void appendInArchive(Path fullPath, String content) {
		try (var writer = new BufferedWriter(new FileWriter(fullPath.toFile(), true))) {
           	writer.write(content);
            System.out.println("[INFO] - Arquivo criado com sucesso.");
        } catch (IOException e) {
            System.err.println("[ERROR] - Ocorreu um erro ao editar o arquivo: " + e.getMessage());
        }
	}
	
	private static void deleteArchive(Path path, String fileName, boolean validateExistance) {
		Path fullPath = path.resolve(fileName);
		if(validateExistance) {
			deleteArchiveIfExists(fullPath);
		} else {
			deleteArchive(fullPath);
		}
	}
	
	private static void deleteArchiveIfExists(Path path) {
		try {
			Files.deleteIfExists(path);
			System.out.println("[INFO] - Arquivo deletado com sucesso.");
		} catch (IOException e) {
			System.err.println("[ERROR] - Erro ao deletar o arquivo: " + e.getMessage());
		}
	}
	
	private static void deleteArchive(Path path) {
		try {
			Files.delete(path);
			System.out.println("[INFO] - Arquivo deletado com sucesso.");
		}catch(IOException e) {
			System.err.println("[ERROR] - O arquivo não deletado: " + e.getMessage());
		}
	}

	public static void main(String... args) throws InterruptedException {
		String fileName = "Evy.java";
		String conteudo = "public class Evy { public static void main(String... args) { System.out.println(\"A Evy é linda\"); } }";//VueComponentsLibrary.RAW_TEMPLATE;
		createArchive(OPT_PATH, fileName);
		appendInArchive(OPT_PATH, fileName, conteudo);
//		Thread.sleep(10000L);
//		deleteArchive(OPT_PATH, fileName, true);
	}

}
