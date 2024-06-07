
## Test Strategy

### Functional Tests

- **Tools**: Cucumber, RestAssured
- **Features**: Located in `src/test/java/features`
    - `collection.feature`: Tests for the Collection API.
    - `art_object.feature`: Tests for the Art Object API.

### Performance Tests

- **Tool**: K6
- **Script**: `k6/load-test.js`
    - Includes average load, stress, and spike testing.

### CI/CD Integration

- **Azure Pipelines**: `azure-pipelines.yml`
    - Stages: smoke, regression, e2e, load tests.
    - Conditional execution ensures that each test stage must pass before the next begins.

## Test Scenarios

### Functional Test Scenarios

1. **Collection API**:
    - Search artworks with valid queries.
    - Use optional parameters for detailed searches.
    - Validate invalid API keys and parameters.

2. **Art Object API**:
    - Retrieve details for specific artworks.
    - Validate responses with optional parameters.
    - Handle non-existent artwork IDs.

### Performance Test Scenarios

1. **Average Load**:
    - Simulates consistent load to ensure stability under normal conditions.

2. **Stress Test**:
    - Tests system behavior under maximum load conditions.

3. **Spike Test**:
    - Evaluates system response to sudden load spikes.

## Running Tests

### Functional Tests

To run functional tests using Maven:

```sh
# Smoke Tests
mvn test -Psmoke-tests

# Regression Tests
mvn test -Pregression-tests

# E2E Tests
mvn test -Pe2e-tests
