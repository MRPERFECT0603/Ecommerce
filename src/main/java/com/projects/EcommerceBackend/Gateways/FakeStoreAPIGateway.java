package com.projects.EcommerceBackend.Gateways;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.EcommerceBackend.DTOs.ProductDTO;
import okhttp3.MediaType;
import org.springframework.beans.factory.annotation.Value;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import okhttp3.RequestBody;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreAPIGateway implements IProductGateway {

    private final String baseUrl;
    private final OkHttpClient client;
    private final ObjectMapper objectMapper;

    // Constructor injection using your AppConfig beans
    public FakeStoreAPIGateway(OkHttpClient client, ObjectMapper objectMapper, @Value("${fakeStore.baseUrl}") String baseUrl) {
        this.client = client;
        this.objectMapper = objectMapper;
        this.baseUrl = baseUrl;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        Request request = new Request.Builder()
                .url(baseUrl)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                throw new IOException("Empty response from FakeStore API");
            }

            ProductDTO[] products = objectMapper.readValue(response.body().string(), ProductDTO[].class);
            return Arrays.asList(products);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch products from FakeStore API", e);
        }
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        try {
            String json = objectMapper.writeValueAsString(productDTO);

            RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
            Request request = new Request.Builder()
                    .url(baseUrl)
                    .post(body)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                if (response.body() == null) {
                    throw new IOException("Empty response from FakeStore API");
                }

                return objectMapper.readValue(response.body().string(), ProductDTO.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to add product to FakeStore API", e);
        }
    }

    @Override
    public ProductDTO getProductById(Integer id) {
        String url = baseUrl + "/" + id; // e.g., https://fakestoreapi.com/products/5

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                throw new IOException("Empty response from FakeStore API for product ID: " + id);
            }

            return objectMapper.readValue(response.body().string(), ProductDTO.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch product with ID " + id + " from FakeStore API", e);
        }
    }


    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        try {
            // Convert ProductDTO to JSON string
            String json = objectMapper.writeValueAsString(productDTO);

            // Create request body
            RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));

            // Construct URL for the specific product
            String url = baseUrl + "/" + id;

            // Build PUT request
            Request request = new Request.Builder()
                    .url(url)
                    .put(body)
                    .build();

            // Execute request
            try (Response response = client.newCall(request).execute()) {
                if (response.body() == null) {
                    throw new IOException("Empty response from FakeStore API for product ID: " + id);
                }

                // Parse and return the updated ProductDTO
                return objectMapper.readValue(response.body().string(), ProductDTO.class);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to update product with ID " + id + " in FakeStore API", e);
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        String url = baseUrl + "/" + id; // e.g., https://fakestoreapi.com/products/5

        Request request = new Request.Builder()
                .url(url)
                .delete()  // HTTP DELETE
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() == null) {
                throw new IOException("Empty response from FakeStore API for product ID: " + id);
            }

            System.out.println("Deleted product with ID: " + id);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete product with ID " + id + " from FakeStore API", e);
        }
    }
}