# Final Year Module Selection Tool 🎓

A comprehensive JavaFX desktop application designed to help final year students manage their module selections and course planning.

## 📋 Project Overview

This application provides an intuitive interface for final year students to:
- Browse available modules for their course
- Select and reserve modules for their final year
- Manage their student profile and course information
- Save and load their module selections
- View course requirements and prerequisites

## 🏗️ Project Structure

```
final-year-module-selection-tool/
├── .eclipse/                    # Eclipse workspace metadata
├── .settings/                   # Eclipse project settings
│   ├── org.eclipse.core.resources.prefs
│   └── org.eclipse.jdt.core.prefs
├── src/                        # Source code directory
│   ├── controller/             # JavaFX Controllers
│   ├── model/                  # Data models
│   ├── view/                   # FXML view files
│   └── application/            # Main application class
├── data/                       # Data persistence files
│   ├── StudentProfile.dat      # Serialized student data
│   └── finalYearObj.dat        # Application state data
├── .classpath                  # Eclipse classpath configuration
├── .project                    # Eclipse project configuration
└── README.md                   # This file
```

## 🚀 Features

### Core Functionality
- **Student Profile Management**: Create and edit comprehensive student profiles
- **Module Selection**: Browse and select from available final year modules
- **Course Integration**: View modules specific to your course pathway
- **Data Persistence**: Save and load your selections between sessions
- **Reservation System**: Reserve modules before final selection
- **Validation**: Ensure module selections meet course requirements

### Technical Features
- **JavaFX GUI**: Modern, responsive desktop interface
- **MVC Architecture**: Clean separation of concerns with Model-View-Controller pattern
- **Data Serialization**: Persistent storage using Java serialization
- **Event Handling**: Comprehensive user interaction management
- **Error Handling**: Robust error management and user feedback

## 🛠️ Technical Specifications

### Requirements
- **Java Version**: Java 17 (JDK 17)
- **Framework**: JavaFX (included in OpenJFX)
- **IDE**: Eclipse IDE (project configured)
- **Architecture**: Model-View-Controller (MVC)

### Key Components

#### Model Classes
- `StudentProfile`: Manages student information and module selections
- `Course`: Represents course structure and requirements
- `Name`: Handles student name formatting and validation
- `Module`: Represents individual course modules

#### Controller Classes
- `FinalYearOptionsController`: Main application controller
- `SaveMenuHandler`: Handles data persistence operations
- Event handlers for user interactions

#### Data Management
- Serialized data files for persistence
- TreeSet collections for efficient module management
- LocalDate integration for scheduling

## 🔧 Setup and Installation

### Eclipse IDE Setup
1. **Import Project:**
   ```
   File → Import → Existing Projects into Workspace
   Select root directory: /path/to/final-year-module-selection-tool
   ```

2. **Configure Build Path:**
   - Right-click project → Properties → Java Build Path
   - Ensure JavaFX libraries are included
   - Verify Java 17 compliance

3. **Run Configuration:**
   - Create new JavaFX Application run configuration
   - Set main class to your Application class
   - Add VM arguments if needed: `--module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml`

### Command Line Compilation
```bash
# Compile with JavaFX
javac --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -d bin src/**/*.java

# Run application
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -cp bin application.MainApp
```

## 🎯 Usage Guide

### Getting Started
1. **Launch Application**: Run the main application class
2. **Create Profile**: Enter your student details and course information
3. **Browse Modules**: Explore available modules for your final year
4. **Make Selections**: Choose modules that fit your career goals
5. **Save Progress**: Use the save functionality to preserve your choices

### Module Selection Process
1. **View Available Modules**: Browse the complete module catalog
2. **Check Prerequisites**: Ensure you meet module requirements
3. **Reserve Modules**: Add interesting modules to your reserved list
4. **Finalize Selection**: Move reserved modules to your final selection
5. **Validate Choices**: Confirm your selection meets degree requirements

### Data Management
- **Auto-Save**: Application automatically saves your progress
- **Manual Save**: Use File → Save to explicitly save your data
- **Load Previous**: Previous sessions are automatically restored
- **Export Data**: Generate reports of your module selections

## 📊 Data Structure

### StudentProfile Structure
```java
class StudentProfile {
    Set<Module> reservedModules;    // Modules under consideration
    Set<Module> selectedModules;    // Final module selections
    Course studentCourse;           // Student's degree course
    LocalDate studentDate;          // Important dates
    String studentEmail;            // Contact information
    Name studentName;               // Student identification
    String studentPnumber;          // Student ID number
}
```

### Serialization Format
- **Binary Serialization**: Java's built-in serialization for data persistence
- **File Format**: `.dat` files for efficient storage and retrieval
- **Version Compatibility**: Maintains backward compatibility with previous saves

## 🔍 Troubleshooting

### Common Issues

#### JavaFX Runtime Issues
```bash
# Add JavaFX modules to runtime
--add-modules javafx.controls,javafx.fxml,javafx.base
```

#### Serialization Errors
- Check for `NotSerializableException` in error logs
- Ensure all model classes implement `Serializable`
- Verify data file permissions and accessibility

#### Eclipse Configuration
- Confirm Java 17 compliance level
- Verify JavaFX libraries in build path
- Check module path configuration

### Performance Optimization
- **Memory Management**: Monitor heap usage for large module catalogs
- **UI Responsiveness**: Use background threads for data loading
- **File I/O**: Implement efficient serialization strategies

## 🎨 User Interface

### Design Principles
- **Intuitive Navigation**: Clear menu structure and workflow
- **Visual Feedback**: Immediate response to user actions
- **Accessibility**: Keyboard navigation and screen reader support
- **Responsive Layout**: Adapts to different screen sizes

### Key Screens
- **Dashboard**: Overview of student progress and selections
- **Module Browser**: Searchable catalog of available modules
- **Selection Manager**: Tools for managing chosen modules
- **Profile Editor**: Student information management
- **Reports**: Summary views and export functionality

## 📈 Future Enhancements

### Planned Features
- **Database Integration**: Replace file-based storage with database
- **Web Interface**: Browser-based version for remote access
- **Advanced Filtering**: Enhanced module search and filtering
- **Collaborative Planning**: Share selections with academic advisors
- **Mobile App**: Companion mobile application
- **Analytics**: Usage statistics and recommendation engine

### Technical Improvements
- **Modern UI Framework**: Upgrade to newer JavaFX versions
- **Cloud Storage**: Integration with cloud storage services
- **Real-time Updates**: Live synchronization of module availability
- **API Integration**: Connect with university information systems

## 🤝 Contributing

### Development Guidelines
1. Follow JavaFX best practices for UI development
2. Maintain MVC architecture separation
3. Add comprehensive JavaDoc documentation
4. Include unit tests for business logic
5. Follow Java coding conventions

### Setting Up Development Environment
```bash
# Clone repository
git clone https://github.com/YOUR_USERNAME/final-year-module-selection-tool.git

# Import into Eclipse
# Configure JavaFX libraries
# Set up run configurations
```

## 📄 License

This project is developed for educational purposes. Feel free to use and modify as needed for similar academic applications.

## 👨‍💻 Development Info

- **Student ID**: P2716927 (based on project structure)
- **IDE**: Eclipse IDE for Java Developers
- **Java Version**: Java 17
- **UI Framework**: JavaFX
- **Architecture**: Model-View-Controller (MVC)

## 📞 Support

For issues with this application:
1. Check the troubleshooting section
2. Review Eclipse console for error messages
3. Verify JavaFX installation and configuration
4. Ensure proper file permissions for data directory

---
*Built with JavaFX and Eclipse IDE ☕*
