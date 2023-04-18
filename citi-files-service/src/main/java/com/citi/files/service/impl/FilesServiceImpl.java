package com.citi.files.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.citi.files.dto.APIResponse;
import com.citi.files.service.FilesService;
import com.opencsv.CSVReader;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FilesServiceImpl implements FilesService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FilesServiceImpl.class);

	@Override
	@Async
	public APIResponse fileProcess(MultipartFile file) throws Exception {

		APIResponse response = new APIResponse();
		List<String[]> rows;
		long columns = 0;

		try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
			rows = reader.readAll();
			long rr = reader.getRecordsRead();

			if (!rows.isEmpty()) {
				String[] firstRow = rows.get(0);
				columns = firstRow.length;
			}

			response.setLinesCount(rows.size() + "");
			response.setColumnCount(columns + "");

		}

		return response;

	}

	@Override
	@Async
	public APIResponse fileProcess2(MultipartFile file) throws Exception {

		APIResponse response = new APIResponse();

		String csvDelimiter = ",";
		ExecutorService executor = Executors.newSingleThreadExecutor();

		CompletableFuture<List<String>> futureRows = CompletableFuture.supplyAsync(() -> {
			List<String> filesList = new ArrayList<>();
			int rowCount = 1;
			int columnCount = 0;
			try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				String line;

				line = br.readLine();
				String[] columns = line.split(csvDelimiter);
				columnCount = columns.length;

				while ((line = br.readLine()) != null) {
					rowCount++;

				}
			} catch (Exception e) {
				LOGGER.error(e.getMessage());

			}

			filesList.add(rowCount + "");
			filesList.add(columnCount + "");

			return filesList;
		}, executor);

		LOGGER.info("future rows :" + futureRows.get());

		response.setLinesCount(futureRows.get().get(0));
		response.setColumnCount(futureRows.get().get(1));

		futureRows.thenAccept(rows -> {

			LOGGER.info("rows:" + rows.get(0));
			LOGGER.info("Columns:" + rows.get(1));

		});

		executor.shutdown();

		return response;

	}

}
